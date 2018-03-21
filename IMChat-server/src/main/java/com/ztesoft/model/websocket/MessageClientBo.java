package com.ztesoft.model.websocket;

import java.io.Serializable;

/**
 * @author kira
 * @created 2018 - 03 - 16 1:52 PM
 */
public class MessageClientBo implements Serializable{
    private MessageClientMine mine;
    private MessageClientTo to;

    public MessageClientMine getMine() {
        return mine;
    }

    public void setMine(MessageClientMine mine) {
        this.mine = mine;
    }

    public MessageClientTo getTo() {
        return to;
    }

    public void setTo(MessageClientTo to) {
        this.to = to;
    }
}
