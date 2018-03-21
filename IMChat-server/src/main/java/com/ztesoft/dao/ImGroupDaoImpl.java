package com.ztesoft.dao;

import com.ztesoft.model.im.ImGroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 14 10:34 AM
 */
@Component
public class ImGroupDaoImpl implements ImGroupDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insertImGroup(ImGroupDto imGroup) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("  insert into IM_GROUP " +
                "(GROUP_ID,GROUP_NAME,GROUP_MEMBER_NUM,FOUNDER,CREATE_TIME) VALUES(?,?,?,?,?)");
        Object[] param = new Object[]{imGroup.getGroupId(),
                imGroup.getGroupName(),imGroup.getGroupMemberNum(),imGroup.getFounder(),imGroup.getCreateTime()};
        this.jdbcTemplate.update(sqlBuf.toString(),param);

    }

    @Override
    public void deleteImGroup(long groupId) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("delete from IM_GROUP WHERE GROUP_ID = ?");
        Object[] param = new Object[]{groupId};
        this.jdbcTemplate.update(sqlBuf.toString(),param);

    }

    @Override
    public void resetImGroup(long groupId) throws Exception {
        ImGroupDto groupDto = this.getImGroupByGroupId(groupId);
        if(groupDto == null ){
            throw new Exception("group does not exists! groupId:"+groupId);
        }else{

            StringBuffer sqlBuf = new StringBuffer("delete from im_group_user_rela where group_id = ? and user_id !=?");
            Object[] param =new Object[]{groupId,groupDto.getFounder()};
            this.jdbcTemplate.update(sqlBuf.toString(),param);
        }
    }

    @Override
    public void updateImGroupMemberNum(long groupId ,long  groupMemberNum) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("update im_group set group_member_num = ? where group_id = ?");
        Object[] param = new Object[]{groupMemberNum,groupId};
        this.jdbcTemplate.update(sqlBuf.toString(),param);
    }

    @Override
    public ImGroupDto getImGroupByGroupId(long groupId) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("Select GROUP_ID AS groupId," +
                "" +
                "       GROUP_NAME AS groupName," +
                "" +
                "       GROUP_MEMBER_NUM AS groupMemberNum," +
                "" +
                "       FOUNDER," +
                "" +
                "       CREATE_TIME AS createTime" +
                "" +
                "  FROM IM_GROUP A WHERE GROUP_ID = ?");
        Object[] param = new Object[]{groupId};
        List<ImGroupDto> list = this.jdbcTemplate.query(sqlBuf.toString(),param, BeanPropertyRowMapper.newInstance(ImGroupDto.class));
        if(list != null && list.size() == 1){
            return list.get(0);
        }
        return  null;
    }

    @Override
    public void insertImGroupUserRela(long groupId, long userId) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("insert into im_group_user_rela (group_id,user_id) values(?,?)");
        Object[] param = new Object[]{groupId,userId};
        this.jdbcTemplate.update(sqlBuf.toString(),param);
    }

    @Override
    public void deleteImGroupUserRealByGroupId(long groupId) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("delete from im_group_user_rela where group_Id = ?");
        Object[] param = new Object[]{groupId};
        this.jdbcTemplate.update(sqlBuf.toString(),param);
    }

    @Override
    public List<ImGroupDto> listUserGroups(long userId) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("Select A.GROUP_ID AS groupId,\n" +
                "       A.GROUP_NAME AS groupName,\n" +
                "       A.GROUP_MEMBER_NUM AS groupMemberNum,\n" +
                "       A.FOUNDER \n" +
                "FROM IM_GROUP A JOIN IM_GROUP_USER_RELA B ON A.GROUP_ID = B.GROUP_ID WHERE B.USER_ID=?");
        Object[] param = new Object[]{userId};
        List<ImGroupDto> list = this.jdbcTemplate.query(sqlBuf.toString(),param,BeanPropertyRowMapper.newInstance(ImGroupDto.class));
        return list;
    }
}
