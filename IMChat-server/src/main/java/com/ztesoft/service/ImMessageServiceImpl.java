package com.ztesoft.service;

import com.ztesoft.dao.ImMessageDao;
import com.ztesoft.model.im.ImMessageDto;
import com.ztesoft.model.im.ImMessagePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 15 10:28 AM
 */
@Component
public class ImMessageServiceImpl implements ImMessageService {


    @Autowired
    private ImMessageDao imMessageDao;
    @Override
    public List<ImMessageDto> listImMessage(long groupId, int from, int size, String type) throws Exception {
        return this.imMessageDao.listImMessage(groupId,from,size,type);
    }

    @Override
    public void insertImMessage(ImMessagePo imMessage) throws Exception {
        this.imMessageDao.insertImMessage(imMessage);
    }
}
