package com.ztesoft.controller;

import com.google.gson.Gson;
import com.ztesoft.model.im.*;
import com.ztesoft.model.Response;
import com.ztesoft.service.ImGroupService;
import com.ztesoft.service.ImUserService;
import com.ztesoft.util.common.Constants;
import com.ztesoft.util.exception.ExceptionUtil;
import com.ztesoft.util.seq.SequenceCreator;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

@RestController
public class ImUserController {



    private static final Logger logger = Logger.getLogger(ImUserController.class);



    @Autowired
    private ImUserService imUserService;
    @Autowired
    private ImGroupService imGroupService;

    @RequestMapping(value = "/imuser/list",method = {RequestMethod.GET})
    public String listGroupMembers(@RequestParam(value="id", required=true) long groupId, HttpServletRequest request){
        List<ImUserDto> list = null;
        List<ImUserVo> voList = new ArrayList<>();
        try {
            list = this.imUserService.listGroupMembersByGroupId(groupId);
            for (ImUserDto userDto:list) {
                voList.add(transUserDtoToUserVo(userDto));
            }

        } catch (Exception e) {
            logger.error(" listGroupMembers occur an error!",e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR, ExceptionUtil.getMessage(e));
        }

        Map listMap = new HashMap<>();
        listMap.put("list", voList);
        return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,listMap);
    }
    @RequestMapping(value="/imuser/add",method = {RequestMethod.POST})
    public String createImUser(@RequestBody String requestBody,HttpServletRequest request ){
        JSONObject json = JSONObject.fromObject(requestBody);
        long userId = 0l;
        try {
             userId = SequenceCreator.getSequence("IM_USER_SEQ");
        } catch (Exception e) {
            logger.error("sequenceCreator obtain IM_USER_SEQ occur an error!",e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
        }
        String userName = json.getString("userName");
        String passwd = json.getString("passwd");
        String mobileTel = json.getString("mobileTel");
        String homeTel = json.getString("homeTel");
        String email = json.getString("email");
        ImUserDto userDto = new ImUserDto();
        userDto.setUserId(userId);
        userDto.setEmaill(email);
        userDto.setHomeTel(homeTel);
        userDto.setMobileTel(mobileTel);
        userDto.setUsername(userName);
        userDto.setPasswd(passwd);
        userDto.setRegisterTime(new Date());
        try {
            this.imUserService.insertImUser(userDto);

        } catch (Exception e) {
            logger.error("create user occur an error !",e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
        }
        return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,userDto);

    }

    @RequestMapping(value="imuser/show",method = {RequestMethod.GET})
    public String getUserAllInfo(HttpServletRequest request){
        String userName = request.getHeader("userName");
        ImVo imVo = new ImVo();
        try {
            ImUserDto userDto = this.imUserService.getImUserByUsername(userName);
            List<ImGroupDto> group = this.imGroupService.listUserGroups(userDto.getUserId());
            imVo.setMine(transUserDtoToUserVo(userDto));
            List<ImGroupVo> groupVoList = new ArrayList<>();
            for (ImGroupDto groupDto:group) {
                groupVoList.add(transGroupDtoToGroupVo(groupDto));
            }
            imVo.setGroup(groupVoList);
        } catch (Exception e) {
            logger.error("getUserAllInfo occur an error ! username:"+userName,e);
            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
        }

        return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,imVo);
    }
    public ImUserVo transUserDtoToUserVo(ImUserDto userDto){
        ImUserVo userVo = new ImUserVo();
        userVo.setId(userDto.getUserId());
        userVo.setAvatar(userDto.getAvatar());
        userVo.setSign(userDto.getSign());
        userVo.setStatus(Constants.USER_STATUS_ONLINE);
        userVo.setUsername(userDto.getUsername());
        return userVo;
    }
    public ImGroupVo transGroupDtoToGroupVo(ImGroupDto groupDto){
        ImGroupVo groupVo = new ImGroupVo();
        groupVo.setId(groupDto.getGroupId());
        groupVo.setAvatar(groupDto.getAvatar());
        groupVo.setGroupname(groupDto.getGroupName());
        return groupVo;
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
