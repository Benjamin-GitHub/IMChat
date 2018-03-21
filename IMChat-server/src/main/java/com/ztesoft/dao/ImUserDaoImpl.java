package com.ztesoft.dao;

import com.ztesoft.model.im.ImUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 14 10:00 AM
 */
@Component
public class ImUserDaoImpl implements ImUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ImUserDto getUosStaffInfoByUsername(String username) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("select username,\n" +
                "       password as passwd,\n" +
                "       MOBILE_TEL AS mobileTel,\n" +
                "       HOME_TEL AS homeTel,\n" +
                "       email\n" +
                "  from uos_staff a where username = ?\n");
        Object[] param = new Object[]{username};
        List<ImUserDto> list = this.jdbcTemplate.query(sqlBuf.toString(),param, BeanPropertyRowMapper.newInstance(ImUserDto.class));
        if(list != null && list.size() == 1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ImUserDto getImUserByUsername(String username) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("Select USER_ID AS userId,\n" +
                "       USER_NAME AS username,\n" +
                "       PASSWD, MOBILE_TEL AS mobileTel,\n" +
                "       HOME_TEL as homeTel,\n" +
                "       EMAIL,\n" +
                "       REGISTER_TIME AS registerTime\n" +
                "  FROM IM_USER A where USER_NAME = ?\n");
        Object[] param = new Object[]{username};
        List<ImUserDto> list = this.jdbcTemplate.query(sqlBuf.toString(),param,BeanPropertyRowMapper.newInstance(ImUserDto.class));
        if(list != null && list.size() == 1){
            return list.get(0);
        }
        return null;

    }

    @Override
    public void insertImUser(ImUserDto user) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("insert into IM_USER" +
                "" +
                "  (USER_ID, USER_NAME, PASSWD, MOBILE_TEL, HOME_TEL, EMAIL, REGISTER_TIME)" +
                "" +
                "VALUES" +
                "" +
                "  (?, ?, ?, ?, ?, ?, sysdate)");
        Object[] param = new Object[]{user.getUserId(),user.getUsername(),user.getPasswd(),user.getMobileTel(),user.getHomeTel(),user.getEmaill()};
        this.jdbcTemplate.update(sqlBuf.toString(),param);
    }

    @Override
    public boolean modifyImUser(ImUserDto user) throws Exception {
        return false;
    }

    @Override
    public List<ImUserDto> listGroupMembersByGroupId(long groupId) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("Select A.USER_ID AS userId,\n" +
                "       a.USER_NAME AS username,\n" +
                "       PASSWD ,MOBILE_TEL AS mobileTel,\n" +
                "       HOME_TEL as homeTel,\n" +
                "       EMAIL,\n" +
                "       REGISTER_TIME AS registerTime\n" +
                "  FROM IM_USER A join IM_GROUP_USER_RELA B ON A.USER_ID = B.USER_ID where GROUP_ID = ?\n");
        Object[] param = new Object[]{groupId};
        List<ImUserDto> list = this.jdbcTemplate.query(sqlBuf.toString(),param,BeanPropertyRowMapper.newInstance(ImUserDto.class));
        return list;
    }

}
