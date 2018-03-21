package com.ztesoft.service;

import com.ztesoft.model.im.ImGroupDto;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 13 3:48 PM
 */
public interface ImGroupService {

    public void insertImGroup(ImGroupDto group)throws Exception;
    public void deleteImGroupById(long id)throws Exception;
    public void resetImGroupMember(long groupId)throws Exception;
    public void addIntoGroup(long groupId,long userId)throws Exception;
    public void deleteImGroupMembersByGroupId(long groupId)throws Exception;
    public void deleteImGroupMemberByUserId(long groupId,long userId)throws Exception;
    public void deleteImGroupMembersByUserIds(long groupId,List<Long> userIds)throws Exception;
    public List<ImGroupDto> listUserGroups(long userId)throws Exception;


}
