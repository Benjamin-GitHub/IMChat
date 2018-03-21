package com.ztesoft.service;

import com.ztesoft.dao.ImUserDao;
import com.ztesoft.model.im.ImUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImUserServiceImpl implements ImUserService {


    @Autowired
    private ImUserDao imUserDao;

    @Override
    public ImUserDto getUosStaffInfoByUsername(String username) throws Exception {
        return imUserDao.getUosStaffInfoByUsername(username);
    }

    @Override
    public ImUserDto getImUserByUsername(String username) throws Exception {
        return imUserDao.getImUserByUsername(username);
    }

    @Override
    public void insertImUser(ImUserDto user) throws Exception {
        imUserDao.insertImUser(user);
    }

    @Override
    public boolean modifyImUser(ImUserDto user) throws Exception {
        return imUserDao.modifyImUser(user);
    }

    @Override
    public List<ImUserDto> listGroupMembersByGroupId(long groupId) throws Exception {
        return imUserDao.listGroupMembersByGroupId(groupId);
    }
}
