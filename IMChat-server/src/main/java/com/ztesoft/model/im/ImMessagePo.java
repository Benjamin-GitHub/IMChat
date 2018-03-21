package com.ztesoft.model.im;

import java.util.Date;

/**
 * @author kira
 * @created 2018 - 03 - 17 8:08 PM
 */
public class ImMessagePo {
    private long MESSAGE_ID;
    private long SPOKEN_MAN;
    private long OBJECT_ID;
    private long TIME_STAMP;
    private String TYPE;
    private Date SEND_TIME;
    private String MESSAGE_CONTENT;

    public long getTIME_STAMP() {
        return TIME_STAMP;
    }

    public void setTIME_STAMP(long TIME_STAMP) {
        this.TIME_STAMP = TIME_STAMP;
    }

    public long getMESSAGE_ID() {
        return MESSAGE_ID;
    }

    public void setMESSAGE_ID(long MESSAGE_ID) {
        this.MESSAGE_ID = MESSAGE_ID;
    }

    public long getSPOKEN_MAN() {
        return SPOKEN_MAN;
    }

    public void setSPOKEN_MAN(long SPOKEN_MAN) {
        this.SPOKEN_MAN = SPOKEN_MAN;
    }

    public long getOBJECT_ID() {
        return OBJECT_ID;
    }

    public void setOBJECT_ID(long OBJECT_ID) {
        this.OBJECT_ID = OBJECT_ID;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public Date getSEND_TIME() {
        return SEND_TIME;
    }

    public void setSEND_TIME(Date SEND_TIME) {
        this.SEND_TIME = SEND_TIME;
    }

    public String getMESSAGE_CONTENT() {
        return MESSAGE_CONTENT;
    }

    public void setMESSAGE_CONTENT(String MESSAGE_CONTENT) {
        this.MESSAGE_CONTENT = MESSAGE_CONTENT;
    }
}
