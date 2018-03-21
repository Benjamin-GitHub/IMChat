package com.ztesoft.dao;

import com.ztesoft.model.im.ImMessageDto;
import com.ztesoft.model.im.ImMessagePo;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 15 9:52 AM
 */
public interface ImMessageDao {

    public List<ImMessageDto> listImMessage(long groupId, int from, int size, String type)throws Exception;

    public void insertImMessage(ImMessagePo messagePo)throws Exception;



}
