package com.ztesoft.service;

import com.ztesoft.dao.ImGroupDao;
import com.ztesoft.model.im.ImGroupDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 15 10:31 AM
 */
@Component
public class ImGroupServiceImpl implements ImGroupService {

    private static final Logger logger = Logger.getLogger(ImGroupServiceImpl.class);
    @Autowired
    private ImGroupDao imGroupDao;

    @Override
    public void insertImGroup(ImGroupDto group) throws Exception {
        this.imGroupDao.insertImGroup(group);

    }

    @Override
    public void deleteImGroupById(long id) throws Exception {
        this.imGroupDao.deleteImGroup(id);
    }

    @Override
    public void resetImGroupMember(long groupId) throws Exception {
        this.imGroupDao.resetImGroup(groupId);
        this.imGroupDao.updateImGroupMemberNum(groupId,1);
    }

    @Override
    public void addIntoGroup(long groupId, long userId) throws Exception {
        this.imGroupDao.insertImGroupUserRela(groupId,userId);
        ImGroupDto groupDto = this.imGroupDao.getImGroupByGroupId(groupId);
        this.imGroupDao.updateImGroupMemberNum(groupId,groupDto.getGroupMemberNum()+1);
    }

    @Override
    public void deleteImGroupMembersByGroupId(long groupId) throws Exception {
        this.imGroupDao.deleteImGroupUserRealByGroupId(groupId);
    }

    @Override
    public void deleteImGroupMemberByUserId(long groupId, long userId) throws Exception {

    }

    @Override
    public void deleteImGroupMembersByUserIds(long groupId, List<Long> userIds) throws Exception {

    }

    @Override
    public List<ImGroupDto> listUserGroups(long userId) throws Exception {
        return this.imGroupDao.listUserGroups(userId);
    }
}
