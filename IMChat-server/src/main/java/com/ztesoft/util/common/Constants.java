package com.ztesoft.util.common;

import java.util.ResourceBundle;

/**
 * @author kira
 * @created 2018 - 03 - 15 3:04 PM
 */
public class Constants {
    public static ResourceBundle resourceBundle = ResourceBundle.getBundle("config.sysconfig");


    public static final String INF_CODE_SUCC = "0";

    public static final String INF_CODE_ERROR = "9999";

    public static final String INF_DESC_SUCC = "success";

    public static final String INF_DESC_ERROR = "error";

    public static final String MESSAGE_TO_TYPE_GROUP ="group";

    public static final String MESSAGE_TO_TYPE_FRIEND ="friend";

    public static final String MESSAGE_TYPE = "chatMessage";

    public static final String USER_STATUS_ONLINE ="online";


    public static void main(String[] args) {
        String code = Constants.resourceBundle.getString("sequence.TIME_OUT");
        System.out.println(code);
    }
}
