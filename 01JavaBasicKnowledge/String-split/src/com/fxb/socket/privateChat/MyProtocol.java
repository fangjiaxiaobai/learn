package com.fxb.socket.privateChat;

/**
 * @create by: wangxiyue on 2017/7/14 17:10.
 * @ClassName:
 * @userfor:
 * @description:
 */
public interface MyProtocol {
    int PROTOCOL_LEN = 2;
    String MSG_ROUND = "&";
    String USER_ROUND = "#";
    String  LOGON_SUCCESS = "1";
    String NAME_REP = "-1";
    String PRIVATE_ROUND = "*";
    String SPLIT_SIGN = "~";

}
