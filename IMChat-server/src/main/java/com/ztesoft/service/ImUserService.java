package com.ztesoft.service;

import com.ztesoft.model.im.ImUserDto;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 13 3:48 PM
 */
public interface ImUserService {




    public ImUserDto getUosStaffInfoByUsername(String username)throws Exception;
    /**
     * get ImUserDto
     * @param username
     * @return
     * @throws Exception
     */
    public ImUserDto getImUserByUsername(String username)throws Exception;

    /**
     * create a ImUserDto
     * @param user
     * @throws Exception
     */
    public void insertImUser(ImUserDto user)throws Exception;

    /**
     * modify ImUserDto
     * @param user
     * @return
     * @throws Exception
     */
    public boolean modifyImUser(ImUserDto user)throws Exception;

    /**
     * list Members of a Group by GroupId
     * @param groupId
     * @return
     * @throws Exception
     */
    public List<ImUserDto> listGroupMembersByGroupId(long groupId)throws Exception;
}
