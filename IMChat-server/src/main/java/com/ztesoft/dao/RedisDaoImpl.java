package com.ztesoft.dao;

import com.ztesoft.util.common.Byte2ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisDaoImpl implements RedisDao{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 从reids集合list弹出内容
     * @param key 集合名称
     * @return
     * @throws Exception
     */
    @Override
    public String pop(final String key) throws Exception {

        Object result =  redisTemplate
                .execute(new RedisCallback<Object>() {
                    @Override
                    public Object doInRedis(RedisConnection connection)
                            throws DataAccessException {

                        byte[] b = connection.lPop(key.getBytes());
                        if (b != null) {
                            String val = Byte2ObjectUtil.byteToObject(b).toString();
                            return val;
                        }
                        return null;
                    }
                });
        if(result!=null){
            return result.toString();
        }
        return null;
    }

    /**
     * 往redis集合结构list push值
     * @param key
     * @param value
     * @throws Exception
     */
    @Override
    public void push(final String key, final String value) throws Exception {

        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.rPush(key.getBytes(), Byte2ObjectUtil.objectToByte(value));
                return null;
            }
        });
    }

}
