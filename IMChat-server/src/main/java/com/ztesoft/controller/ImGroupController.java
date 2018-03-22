package com.ztesoft.controller;

import com.google.gson.Gson;
import com.ztesoft.model.im.ImGroupDto;
import com.ztesoft.model.im.ImUserDto;
import com.ztesoft.model.Response;
import com.ztesoft.service.ImGroupService;
import com.ztesoft.service.ImUserService;
import com.ztesoft.util.common.Constants;
import com.ztesoft.util.exception.ExceptionUtil;
import com.ztesoft.util.seq.SequenceCreator;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class ImGroupController {

    private static final Logger logger = Logger.getLogger(ImGroupController.class);
    @Autowired
    private ImGroupService imGroupService ;

    @Autowired
    private ImUserService imUserService;

    /**
     *
     * @param groupName
     * @param request
     * @return
     */
    @RequestMapping(value = "/imgroup/add/{groupName}",method = {RequestMethod.POST})
    public String createImGroup(@PathVariable String groupName, HttpServletRequest request){
        String userName = request.getHeader("userName");
        ImUserDto user = null;
        try {
            user = imUserService.getImUserByUsername(userName);
        } catch (Exception e) {
            logger.error("getImUserByUsername occur an error!\r\n",e);
        }
        if(user == null){
            logger.info("founder does not exists! and then will create it!");
            try {
                user = imUserService.getUosStaffInfoByUsername(userName);
            } catch (Exception e) {
                logger.error("createImGroup--getUosStaffInfoByUsername occur an error!",e);
            }
            if(user != null){
                long userId = 0;
                try {
                    userId = SequenceCreator.getSequence("IM_USER_SEQ");
                } catch (Exception e) {
                    logger.error("SequenceCreator get IM_USER_SEQ error!",e);
                    return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));

                }
                user.setUserId(userId);
                try {
                    imUserService.insertImUser(user);
                } catch (Exception e) {
                    logger.error("create user occur an  error!",e);
                    return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));                }
            }
        }
        ImGroupDto group = new ImGroupDto();
        group.setGroupMemberNum(0);
        group.setGroupName(groupName);
        group.setFounder(user.getUserId());
        long groupId = 0;
        try {
            groupId = SequenceCreator.getSequence("IM_GROUP_SEQ");
        } catch (Exception e) {
            logger.error("get groupId seq occur an error !",e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
        }

        group.setGroupId(groupId);
        group.setCreateTime(new Date());
        try {
            this.imGroupService.insertImGroup(group);
            this.imGroupService.addIntoGroup(groupId,user.getUserId());
            return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,group);

        } catch (Exception e) {
            logger.error("insert into im_group occur an error!\r\n",e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
        }
    }

    /**
     *
     * @param groupId
     * @param request
     */
    @RequestMapping(value = "/imgroup/delete/{groupId}",method = {RequestMethod.DELETE})
    public String deleteImGroup(@PathVariable long groupId, HttpServletRequest request) {
       // String userName = request.getHeader("userName");
        try {
            this.imGroupService.deleteImGroupById(groupId);
            this.imGroupService.deleteImGroupMembersByGroupId(groupId);

        } catch (Exception e) {
            logger.error(" delete im_group occur an error!groupId:"+groupId,e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
        }
        return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,null);

    }

    /**
     *
     * @param groupId
     * @param request
     * @return
     */
    @RequestMapping(value = "/imgroupuserrela/reset/{groupId}",method = {RequestMethod.DELETE})
    public String resetImGroup(@PathVariable long  groupId, HttpServletRequest request) {
       // String userName = request.getHeader("userName");
        try {
            this.imGroupService.resetImGroupMember(groupId);
            return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,null);
         } catch (Exception e) {
            logger.error("resetImGroupMember occur an error!\r\n",e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));

        }
    }


    /**
     *
     * @param groupId
     * @param userNames
     * @param request
     * @return
     */
    @RequestMapping(value = "/imgroupuserrela/add/{groupId}/{userNames}",method = {RequestMethod.POST})
    public String addIntoImGroup(@PathVariable long groupId,@PathVariable String userNames, HttpServletRequest request) {
        String[] usernameArr = userNames.split(",");
        for (int i = 0; i < usernameArr.length ; i++) {
            ImUserDto user = null;
            try {
                user = this.imUserService.getImUserByUsername(usernameArr[i]);
            } catch (Exception e) {
                logger.error("find user occur an error !",e);
                return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
            }
            if(user == null){
                    logger.info("founder does not exists! and then will create it!");
                    try {
                        user = imUserService.getUosStaffInfoByUsername(usernameArr[i]);
                    } catch (Exception e) {
                        logger.error("createImGroup--getUosStaffInfoByUsername occur an error!",e);
                    }
                    if(user != null){
                        long userId = 0;
                        try {
                            userId = SequenceCreator.getSequence("IM_USER_SEQ");
                        } catch (Exception e) {
                            logger.error("SequenceCreator get IM_USER_SEQ error!",e);
                            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));

                        }
                        user.setUserId(userId);
                        try {
                            imUserService.insertImUser(user);
                        } catch (Exception e) {
                            logger.error("create user occur an  error!",e);
                            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
                        }
                        try {
                            this.imGroupService.addIntoGroup(groupId,user.getUserId());
                        } catch (Exception e) {
                            logger.error("addIntoGroup occur an error !",e);
                            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
                        }
                    }else{
                        logger.error("please checke username :"+usernameArr[i]+"database does not exist this user");
                    }
                }else{
                    try {
                        this.imGroupService.addIntoGroup(groupId,user.getUserId());
                    } catch (Exception e) {
                        logger.error("addIntoGroup occur an error !",e);
                        return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
                    }
                }

        }
        return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,null);
    }

    /**
     * 移除讨论组成员,不能移除创建者
     * @param groupId
     * @param userIds
     * @param request
     * @return
     */
    @RequestMapping(value = "/imgroupuserrela/delete/{groupId}/{userIds}",method = {RequestMethod.DELETE})
    public String deleteImGroupMembersByUserIds(@PathVariable long groupId,@PathVariable String userIds, HttpServletRequest request) {

        try {
            // 转换long类型的数组
            Long[] userIdArr = (Long[]) ConvertUtils.convert(userIds.split(","),Long.class);
            List<Long> userIdList = Arrays.asList(userIdArr);
            List<Long> userIdArrayList = new ArrayList<>(userIdList);
            this.imGroupService.deleteImGroupMembersByUserIds(groupId, userIdArrayList);
        } catch (Exception e) {
            logger.error("deleteImGroupMembers occur an error !",e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
        }
        return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,null);
    }

    private String feedback(String code,String desc,Object obj){
        Gson gson = new Gson();
        Response response = new Response();
        response.setCode(code);
        response.setResultDesc(desc);
        response.setData(obj);
        return gson.toJson(response);
    }

}
