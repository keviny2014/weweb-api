package com.weweb.common.entity;

/**
 * Created by wshen on 5/4/2017.
 */
public enum CodeMessage {
	SUCCESS("200","Successful operation"),
    ERROR405("405","Request not allowed"),
    SERVER_ERROR( "500","Server business"),
    OPERATE_FAIL( "505","Operate fail"),
    INVALIDTOKEN("507", "Invalid token, expired token or wrong token type"),
    UNAUTHUSER("508", "Unauthenticated user. Please sign in first"),
    INVALID_PARAMETER("509","Request parameter is wrong"),
    OFLINENOTIFICATION("520", "Warning, your account is logged in from another device");


	private String code;
    private String message;

    CodeMessage(String code,String message) {
        this.code = code;
		this.message = message;
	}

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
