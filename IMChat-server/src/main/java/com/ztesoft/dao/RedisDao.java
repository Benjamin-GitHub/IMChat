package com.ztesoft.dao;

public interface RedisDao {

    /**
     * 从reids集合list弹出内容
     * @param key 集合名称
     * @return
     * @throws Exception
     */
    public String pop(final String key) throws Exception;

    /**
     * 往redis集合结构list push值
     * @param key
     * @param value
     * @throws Exception
     */
    public void push(final String key, final String value) throws Exception;
}
