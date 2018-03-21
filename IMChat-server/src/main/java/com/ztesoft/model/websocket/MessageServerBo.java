package com.ztesoft.model.websocket;

import java.io.Serializable;

/**
 * @author kira
 * @created 2018 - 03 - 16 2:55 PM
 */
public class MessageServerBo implements Serializable{
    private String type;
    private Object data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
