package com.ztesoft.model.im;

import java.io.Serializable;
import java.util.Date;

public class ImGroupDto implements Serializable {

    private long groupId;

    private String groupName;

    private long groupMemberNum;

    private long founder;

    private String avatar;

    private Date createTime;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getGroupMemberNum() {
        return groupMemberNum;
    }

    public void setGroupMemberNum(long groupMemberNum) {
        this.groupMemberNum = groupMemberNum;
    }

    public long getFounder() {
        return founder;
    }

    public void setFounder(long founder) {
        this.founder = founder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
