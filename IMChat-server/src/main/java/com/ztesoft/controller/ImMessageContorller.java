package com.ztesoft.controller;

import com.google.gson.Gson;
import com.ztesoft.model.im.ImMessageDto;
import com.ztesoft.model.Response;
import com.ztesoft.model.im.ImMessageVo;
import com.ztesoft.service.ImMessageService;
import com.ztesoft.util.common.Constants;
import com.ztesoft.util.exception.ExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author kira
 * @created 2018 - 03 - 13 3:43 PM
 */
@RestController
public class ImMessageContorller {
    private static final Logger logger = Logger.getLogger(ImMessageContorller.class);

    @Autowired
    private ImMessageService imMessageService;
    @RequestMapping(value = "/immessage/list/{objectId}/{type}/{from}/{size}")
    public String listImMessage(@PathVariable long objectId,@PathVariable String type,@PathVariable int from,@PathVariable int size, HttpServletRequest request){
        List<ImMessageDto> list = null;
        List<ImMessageVo> voList = new ArrayList<>();
        try {
            list = this.imMessageService.listImMessage(objectId,from,size, type);
            for (ImMessageDto messageDto:list) {
             voList.add(transMessageDtoToMessageVo(messageDto));
            }
        } catch (Exception e) {
            logger.error("list immessage occur an  error !",e);

            return feedback(Constants.INF_CODE_ERROR,Constants.INF_DESC_ERROR,ExceptionUtil.getMessage(e));
        }
        return feedback(Constants.INF_CODE_SUCC,Constants.INF_DESC_SUCC,voList);
    }



    private ImMessageVo transMessageDtoToMessageVo(ImMessageDto messageDto){
        ImMessageVo messageVo = new ImMessageVo();
        messageVo.setId(messageDto.getMessageId());
        messageVo.setUserId(messageDto.getSpokenMan());
        messageVo.setAvatar(messageDto.getAvatar());
        messageVo.setUsername(messageDto.getUsername());
        messageVo.setContent(messageDto.getMessageContent());
        messageVo.setTimestamp(messageDto.getTimestamp());
        return messageVo;
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
