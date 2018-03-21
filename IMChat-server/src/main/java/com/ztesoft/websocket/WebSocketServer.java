package com.ztesoft.websocket;

import com.google.gson.Gson;
import com.ztesoft.model.im.ImGroupDto;
import com.ztesoft.model.im.ImMessageDto;
import com.ztesoft.model.im.ImMessagePo;
import com.ztesoft.model.im.ImUserDto;
import com.ztesoft.model.websocket.*;
import com.ztesoft.service.*;
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
    private static final  ConcurrentHashMap<String,Session> userOnlineSession = new ConcurrentHashMap<String,Session>();


    private ImUserService imUserService = SpringApplicationContextFactory.getApplicationContext().getBean(ImUserServiceImpl.class)  ;

    private ImMessageService imMessageService = SpringApplicationContextFactory.getApplicationContext().getBean(ImMessageServiceImpl.class);

    private ImGroupService imGroupService = SpringApplicationContextFactory.getApplicationContext().getBean(ImGroupServiceImpl.class);
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(@PathParam("username")String username, Session session) {
        userOnlineSession.put(username,session);     //加入map中
        try {
            ImUserDto user  = imUserService.getImUserByUsername(username);
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

        sendSysNotice(username,"new user : "+username+" online!");


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
        sendSysNotice(username," user : "+username+" disconnected!");
        userOnlineSession.remove(username);  //从set中删除
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
        long  messageId = 0l;
        long  objectId = 0l;
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
            try {
                List<ImUserDto> users = this.imUserService.listGroupMembersByGroupId(objectId);
                for (ImUserDto user : users) {
                    if(receData.getMine().getId() != user.getUserId()){
                        userData.setMine(false);
                        sendMessage(user.getUsername(),gson.toJson(sendBo));
                    }
                }
            } catch (Exception e) {
                logger.error("listGroupMembersByGroupId occur an  error !",e);

            }
        }else{

        }


       /* //群发消息
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }

    /**
     * 发生错误时调用
     * */
     @OnError
     public void onError(@PathParam("username")String username,Session session, Throwable error) {
         logger.error("user onError occur! usernmae:"+username,error);
     }


     public void sendMessage(String username,String message) throws IOException {
         if(userOnlineSession.get(username) != null){
             userOnlineSession.get(username).getBasicRemote().sendText(message);
             logger.info(message);


         }
     }

     public void sendSysNotice(String username,String notice){
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
                     sendMessage(userVo.getUsername(),gson.toJson(sendBo));
                 }
             }
         } catch (Exception e) {
             logger.error("query user occur an error!",e);

         }
     }


    public static synchronized int getOnlineCount() {
        return onlineCount.get();
    }

    public static synchronized int addOnlineCount(String username) {

        return onlineCount.incrementAndGet();
    }

    public static synchronized void subOnlineCount() {
        onlineCount.decrementAndGet();
    }
}