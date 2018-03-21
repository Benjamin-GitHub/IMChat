package com.ztesoft.model.im;

import java.io.Serializable;

/**
 * @author kira
 * @created 2018 - 03 - 17 6:45 PM
 */
public class ImUserVo implements Serializable{
    private long id;
    private String username;
    private String status;
    private String sign;
    private String avatar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
