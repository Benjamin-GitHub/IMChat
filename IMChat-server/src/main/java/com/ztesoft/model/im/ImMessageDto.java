package com.ztesoft.model.im;

import java.io.Serializable;
import java.util.Date;

public class ImMessageDto implements Serializable{

    private long messageId;
    private long spokenMan;
    private long objectId;
    private String type;
    private String messageContent;
    private Date sendTime;
    private long timestamp;
    private String avatar;
    private String username;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getSpokenMan() {
        return spokenMan;
    }

    public void setSpokenMan(long spokenMan) {
        this.spokenMan = spokenMan;
    }



    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
