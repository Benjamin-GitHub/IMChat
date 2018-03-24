package com.ztesoft.util.common;

import java.util.ResourceBundle;

/**
 * @author kira
 * @created 2018 - 03 - 15 3:04 PM
 */
public class Constants {
    public static ResourceBundle sysBundle = ResourceBundle.getBundle("config.sysconfig");
    public static ResourceBundle aliyunBundle = ResourceBundle.getBundle("config.aliyun");


    public static final String INF_CODE_SUCC = "0";

    public static final String INF_CODE_ERROR = "9999";

    public static final String INF_DESC_SUCC = "success";

    public static final String INF_DESC_ERROR = "error";

    public static final String MESSAGE_TO_TYPE_GROUP ="group";

    public static final String MESSAGE_TO_TYPE_FRIEND ="friend";

    public static final String MESSAGE_TYPE = "chatMessage";

    public static final String USER_STATUS_ONLINE ="online";

    //----aliyun---
    public static final String APP_KEY_ID = aliyunBundle.getString("aliyun.app.key.id");
    public static final String APP_KEY_SECRET = aliyunBundle.getString("aliyun.app.key.secret");
    public static final String CHAT_INSTANCE_ID = aliyunBundle.getString("aliyun.xiaomi.instance.id");
    public static final String CHAT_API_URL = aliyunBundle.getString("aliyun.xiaomi.api.url");
    public static final String CHAT_REGION_ID = aliyunBundle.getString("aliyun.xiaomi.region.id");
    public static final Long CHAT_GROUP_ID =Long.parseLong(aliyunBundle.getString("aliyun.xiaomi.im.groupId"));
    public static final String CHAT_RECOMMEND_DEFAULT = "我猜你想问:";
            ;



    public static void main(String[] args) {
        String code = Constants.sysBundle.getString("sequence.TIME_OUT");
        System.out.println(code);
    }
}
