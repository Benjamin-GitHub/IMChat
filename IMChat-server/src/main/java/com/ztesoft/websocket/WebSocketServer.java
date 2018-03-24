package com.ztesoft.websocket;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.chatbot.model.v20171011.ChatResponse;
import com.aliyuncs.http.FormatType;
import com.google.gson.Gson;
import com.ztesoft.model.im.ImGroupDto;
import com.ztesoft.model.im.ImMessagePo;
import com.ztesoft.model.im.ImUserDto;
import com.ztesoft.model.websocket.*;
import com.ztesoft.service.*;
import com.ztesoft.util.aliyun.MessageType;
import com.ztesoft.util.aliyun.XiaoMiUtil;
import com.ztesoft.util.common.Constants;
import com.ztesoft.util.seq.SequenceCreator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/websocket/{username}")
@Component
public class WebSocketServer {

    private static final Logger logger = Logger.getLogger(WebSocketServer.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    //concurrent包的线程安全Map，用来存放每个客户端对应的MyWebSocket对象。
    private static final  ConcurrentHashMap<String,Session> userOnlineSession = new ConcurrentHashMap<>();

    private static final  ConcurrentHashMap<String,String> userAliyunSession = new ConcurrentHashMap<>();

    private ImUserService imUserService = SpringApplicationContextFactory.getApplicationContext().getBean(ImUserServiceImpl.class)  ;

    private ImMessageService imMessageService = SpringApplicationContextFactory.getApplicationContext().getBean(ImMessageServiceImpl.class);

    private ImGroupService imGroupService = SpringApplicationContextFactory.getApplicationContext().getBean(ImGroupServiceImpl.class);

    private RedisService redisService = SpringApplicationContextFactory.getApplicationContext().getBean(RedisService.class);
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(@PathParam("username")String username, Session session) {
        userOnlineSession.put(username,session);     //加入map中
        ImUserDto user;
        try {
            user  = imUserService.getImUserByUsername(username);
            if(user == null){
                user = imUserService.getUosStaffInfoByUsername(username);
                if(user != null){
                    long userId = SequenceCreator.getSequence("IM_USER_SEQ");
                    user.setUserId(userId);
                    imUserService.insertImUser(user);
                }
            }
        } catch (Exception e) {
            logger.error("find user occur an error!",e);
        }

        // 查看该用户是否有未读消息,若有则发送消息
        try {
            String message = redisService.pop(
                    Constants.sysBundle.getString("redis.key.unread.message") + username);
            while (null!=message && !"".equals(message)) {
                sendMessage(username, message, true);
                message = redisService.pop(
                        Constants.sysBundle.getString("redis.key.unread.message") + username);
            }
        } catch (Exception e) {
            logger.error("获取redis消息队列失败!", e);
        }


        sendSysNotice(username,"new user : "+username+" online!", false);

        int onlineMembers = addOnlineCount(username);           //在线数加1
        if(logger.isInfoEnabled()){
            logger.info("new user connected!username:"+username +" and onlinemember is :" +onlineMembers);
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("username")String username) {
        userOnlineSession.remove(username);  //从set中删除
        sendSysNotice(username," user : "+username+" disconnected!", false);
        subOnlineCount();           //在线数减1
        if(logger.isInfoEnabled()){
            logger.info("用户连接关闭！当前在线人数为" + getOnlineCount()+"  "+username +" 用户退出");
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(@PathParam("username")String username, String message, Session session) {
        if(logger.isDebugEnabled()){
            logger.debug("received  from client:" + username +" and message is:"+message);
        }
        Gson gson = new Gson();
        MessageClientBo receData = gson.fromJson(message, MessageClientBo.class);
        logger.info(gson.toJson(receData));
        ImMessagePo messagePo = new ImMessagePo();
        long  messageId = 0L;
        long  objectId = 0L;
        try {
              messageId = SequenceCreator.getSequence("IM_MESSAGE_SEQ");
        } catch (Exception e) {
            logger.error("SequenceCreator get IM_MESSAGE_SEQ occur an error!",e);

        }
        objectId = receData.getTo().getId();
        messagePo.setMESSAGE_ID(messageId);
        messagePo.setMESSAGE_CONTENT(receData.getMine().getContent());
        messagePo.setOBJECT_ID(receData.getTo().getId());
        messagePo.setSEND_TIME(new Date());
        messagePo.setSPOKEN_MAN(receData.getMine().getId());
        messagePo.setTYPE(receData.getTo().getType());
        messagePo.setTIME_STAMP(System.currentTimeMillis());
        try {
            this.imMessageService.insertImMessage(messagePo);
        } catch (Exception e) {
            logger.error("insert into message occur an error !",e);
        }
        MessageServerBo sendBo = new MessageServerBo();
        MessageServerUserData userData = new MessageServerUserData();
        sendBo.setType(Constants.MESSAGE_TYPE);
        sendBo.setData(userData);
        userData.setCid(messageId);
        userData.setAvatar(receData.getMine().getAvatar());
        userData.setContent(receData.getMine().getContent());
        userData.setFromid(receData.getMine().getId());
        userData.setId(receData.getTo().getId());
        userData.setType(receData.getTo().getType());
        userData.setUsername(receData.getMine().getUsername());
        userData.setTimestamp(System.currentTimeMillis());
        if(Constants.MESSAGE_TO_TYPE_GROUP.equals(receData.getTo().getType())){
            //群组ID是小蜜组的说明是智能问答，
            if(objectId == Constants.CHAT_GROUP_ID){
                String sessionId = userAliyunSession.get(username);
                ChatResponse response = XiaoMiUtil.doAction(receData.getMine().getContent(), sessionId,FormatType.JSON);
                sessionId = response.getSessionId();
                userAliyunSession.put(username,sessionId);
                try {
                    for (ChatResponse.Message messageVo:response.getMessages()) {
                        if(messageVo.getType().equalsIgnoreCase(MessageType.TEXT.getType())){
                            logger.info(JSON.toJSONString(messageVo));
                            userData.setContent(messageVo.getText().getContent());
                        }else if(messageVo.getType().equalsIgnoreCase(MessageType.KNOWLEDGE.getType())){
                            logger.info(JSON.toJSONString(messageVo));
                            userData.setContent(messageVo.getKnowledge().getSummary());
                        }else if(messageVo.getType().equalsIgnoreCase(MessageType.RECOMMEND.getType())){
                            List<ChatResponse.Message.Recommend> recommends = messageVo.getRecommends();
                            StringBuffer content = new StringBuffer(Constants.CHAT_RECOMMEND_DEFAULT).append("\r\n");
                            for (int i = 0; i <recommends.size() ; i++) {
                                content.append(recommends.get(i).getTitle()).append("\r\n");
                            }
                            userData.setContent(content.toString());
                            logger.info(JSON.toJSONString(messageVo));

                        }
                    }
                    userData.setFromid(Constants.CHAT_GROUP_ID);
                    userData.setUsername("智能一点通");
                    sendMessage(username,gson.toJson(sendBo),true);
                } catch (IOException e) {
                    logger.error("sendMessage occur an error !",e);
                }
            }else{
                try {
                    List<ImUserDto> users = this.imUserService.listGroupMembersByGroupId(objectId);
                    for (ImUserDto user : users) {
                        if(receData.getMine().getId() != user.getUserId()){
                            userData.setMine(false);
                            sendMessage(user.getUsername(), gson.toJson(sendBo), true);
                        }
                    }
                } catch (Exception e) {
                    logger.error("listGroupMembersByGroupId occur an  error !",e);

                }
            }

        }else{

        }


    }

    /**
     * 发生错误时调用
     * */
     @OnError
     public void onError(@PathParam("username")String username,Session session, Throwable error) {
         logger.error("user onError occur! usernmae:"+username,error);
     }

    /**
     * 给用户发送信息
     * @param username   用户名
     * @param message    信息内容
     * @param storeMessage  是否需要通知未上线用户,
     *                      为true时,若用户未上线,则会把信息保存到redis中,用户上线时再从redis中获取信息
     * @throws IOException
     */
     public void sendMessage(String username,String message, boolean storeMessage) throws IOException {
         // 若用户已上线,直接发送消息
         if(userOnlineSession.get(username) != null){
             userOnlineSession.get(username).getBasicRemote().sendText(message);
             logger.info(message);
         // 否则把消息存到redis队列中,队列名为username_userId
         } else if (userOnlineSession.get(username) == null && storeMessage == true){
             try {
                 redisService.push(
                         Constants.sysBundle.getString("redis.key.unread.message") + username, message);
             } catch (Exception e) {
                 logger.error("消息存入redis失败",e);
             }
         }
     }

    /**
     * 发送系统通知
     * @param username 用户名
     * @param notice   系统通知内容
     * @param storeMessage 是否需要通知未上线用户,
     *                      为true时,若用户未上线,则会把信息保存到redis中,用户上线时再从redis中获取信息
     */
     public void sendSysNotice(String username,String notice, boolean storeMessage){
         Gson gson = new Gson();
         MessageServerBo sendBo = new MessageServerBo();
         MessageServerSysData sysData = new MessageServerSysData();
         sendBo.setType(Constants.MESSAGE_TYPE);
         sendBo.setData(sysData);
         sysData.setContent(notice);
         ImUserDto user = null;
         try {
             user = this.imUserService.getImUserByUsername(username);
             List<ImGroupDto> groupDtos = this.imGroupService.listUserGroups(user.getUserId());
             for (ImGroupDto group:groupDtos) {
                 sysData.setId(group.getGroupId());
                 sysData.setType(Constants.MESSAGE_TO_TYPE_GROUP);
                 sysData.setSystem(true);
                 List<ImUserDto> users = this.imUserService.listGroupMembersByGroupId(group.getGroupId());
                 for (ImUserDto userVo: users) {
                     sendMessage(userVo.getUsername(), gson.toJson(sendBo), storeMessage);
                 }
             }
         } catch (Exception e) {
             logger.error("query user occur an error!",e);

         }
     }


    private static synchronized int getOnlineCount() {
        return onlineCount.get();
    }

    private static synchronized int addOnlineCount(String username) {
        return onlineCount.incrementAndGet();
    }

    private static synchronized void subOnlineCount() {
        onlineCount.decrementAndGet();
    }
}