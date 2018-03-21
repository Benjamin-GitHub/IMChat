package com.ztesoft.service;

import com.ztesoft.model.im.ImMessageDto;
import com.ztesoft.model.im.ImMessagePo;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 13 4:07 PM
 */
public interface ImMessageService {

    /**
     * list ImMessages by from and sizes
     * @param from
     * @param size
     * @param type
     * @return
     * @throws Exception
     */

    public List<ImMessageDto> listImMessage(long groupId, int from, int size, String type)throws Exception;

    public void insertImMessage(ImMessagePo imMessage)throws Exception;

}
