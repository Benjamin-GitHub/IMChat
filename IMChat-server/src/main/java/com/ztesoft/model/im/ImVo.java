package com.ztesoft.model.im;

import java.io.Serializable;
import java.util.List;

/**
 * @author kira
 * @created 2018 - 03 - 17 6:34 PM
 */
public class ImVo implements Serializable {
    private ImUserVo mine;
    private List<ImUserVo> friend;
    private List<ImGroupVo> group;

    public ImUserVo getMine() {
        return mine;
    }

    public void setMine(ImUserVo mine) {
        this.mine = mine;
    }

    public List<ImUserVo> getFriend() {
        return friend;
    }

    public void setFriend(List<ImUserVo> friend) {
        this.friend = friend;
    }

    public List<ImGroupVo> getGroup() {
        return group;
    }

    public void setGroup(List<ImGroupVo> group) {
        this.group = group;
    }
}
