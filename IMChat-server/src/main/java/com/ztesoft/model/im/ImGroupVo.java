package com.ztesoft.model.im;

import java.io.Serializable;

/**
 * @author kira
 * @created 2018 - 03 - 17 6:45 PM
 */
public class ImGroupVo implements Serializable{
    private long id;
    private String groupname;
    private String avatar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
