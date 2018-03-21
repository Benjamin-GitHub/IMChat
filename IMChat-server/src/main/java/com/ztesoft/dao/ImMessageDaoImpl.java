package com.ztesoft.dao;

import com.ztesoft.model.im.ImMessageDto;
import com.ztesoft.model.im.ImMessagePo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 15 9:53 AM
 */
@Component
public class ImMessageDaoImpl implements ImMessageDao {

    private static final Logger logger = Logger.getLogger(ImMessageDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<ImMessageDto> listImMessage(long groupId, int from, int size, String type) throws Exception {
//        StringBuffer sqlBuf = new StringBuffer("SELECT MESSAGE_ID AS messageId,\n" +
//                "       SPOKEN_MAN AS spokenMan,\n" +
//                "       OBJECT_ID AS objectId,\n" +
//                "       SEND_TIME as sendTime,\n" +
//                "       C.USER_NAME AS USERNAME,\n" +
//                "       C.AVATAR,\n" +
//                "       C.SIGN,\n" +
//                "       MESSAGE_CONTENT AS messageContent\n" +
//                "  FROM (SELECT A.*, ROWNUM RN\n" +
//                "          FROM (SELECT * FROM IM_MESSAGE) A\n" +
//                "         WHERE ROWNUM <= ?\n" +
//                "           AND TYPE = ?\n" +
//                "           and OBJECT_ID = ?) B\n" +
//                "  JOIN IM_USER C ON C.USER_ID = B.SPOKEN_MAN\n" +
//                " WHERE RN >= ?");
//
//        Object[] param = new Object[]{from+size,type,groupId,from};

        StringBuffer sqlBuf = new StringBuffer("SELECT MESSAGE_ID AS messageId, SPOKEN_MAN AS spokenMan, OBJECT_ID AS objectId, " +
                "SEND_TIME AS sendTime, C.USER_NAME AS USERNAME, C.AVATAR, C.SIGN, " +
                "MESSAGE_CONTENT AS messageContent, TIME_STAMP AS timestamp " +
                "FROM ( " +
                "    SELECT A.*, ROWNUM RN " +
                "    FROM ( " +
                "        SELECT * FROM IM_MESSAGE " +
                "        WHERE TYPE = ? AND OBJECT_ID = ? AND MESSAGE_ID < ? " +
                "        ORDER BY MESSAGE_ID DESC " +
                "    ) A WHERE ROWNUM<=? ORDER BY MESSAGE_ID " +
                ") B " +
                "JOIN IM_USER C ON C.USER_ID = B.SPOKEN_MAN ");
        if (from < 0) {
            from = Integer.MAX_VALUE;
        }
        Object[] param = new Object[]{type, groupId, from, size};

        if(logger.isDebugEnabled()){
            logger.debug("listImMessage-sql:"+sqlBuf.toString());
        }

        List<ImMessageDto> list = this.jdbcTemplate.query(sqlBuf.toString(),param, BeanPropertyRowMapper.newInstance(ImMessageDto.class));
        return list;
    }

    @Override
    public void insertImMessage(ImMessagePo messagePo) throws Exception {
        StringBuffer sqlBuf = new StringBuffer("insert into im_message(MESSAGE_ID,SPOKEN_MAN," +
                "TYPE,OBJECT_ID,MESSAGE_CONTENT,SEND_TIME,TIME_STAMP)" +
                "VALUES(?,?,?,?,?,?,?)");
        Object[] param = new Object[]{messagePo.getMESSAGE_ID(), messagePo.getSPOKEN_MAN(),messagePo.getTYPE(),messagePo.getOBJECT_ID()
        ,messagePo.getMESSAGE_CONTENT(),messagePo.getSEND_TIME(),messagePo.getTIME_STAMP()};
        this.jdbcTemplate.update(sqlBuf.toString(),param);
    }
}
