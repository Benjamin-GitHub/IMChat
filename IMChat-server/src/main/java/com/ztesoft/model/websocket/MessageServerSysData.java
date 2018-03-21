package com.ztesoft.model.websocket;

import java.io.Serializable;

/**
 * @author kira
 * @created 2018 - 03 - 16 3:21 PM
 */
public class MessageServerSysData implements Serializable {

    private boolean system;
    private long id;
    private String type;
    private String content;

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
