package com.ztesoft.service;

import com.ztesoft.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceImpl implements RedisService{

    @Autowired
    private RedisDao redisDao;

    @Override
    public String pop(String key) throws Exception {
        return redisDao.pop(key);
    }

    @Override
    public void push(String key, String value) throws Exception {
        redisDao.push(key, value);
    }
}
