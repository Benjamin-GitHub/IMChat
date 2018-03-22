package com.ztesoft.dao;

import com.ztesoft.model.im.ImGroupDto;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 14 10:28 AM
 */
public interface ImGroupDao {

    public void insertImGroup(ImGroupDto imGroup)throws Exception;
    public void deleteImGroup(long groupId)throws Exception;
    public void resetImGroup(long groupId)throws Exception;
    public void updateImGroupMemberNum(long groupId,long groupMemberNum)throws Exception;
    public ImGroupDto getImGroupByGroupId(long groupId)throws Exception;
    public void insertImGroupUserRela(long groupId,long userId)throws Exception;
    public void deleteImGroupUserRealByGroupId(long groupId)throws Exception;
    public List<ImGroupDto> listUserGroups(long userId)throws Exception;
    public void deleteImGroupMember(long groupId, long userId) throws Exception;

}
