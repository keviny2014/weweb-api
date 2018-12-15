package com.weweb.common.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;

/**
 * Created by wshen on 5/4/2017.
 */
@ApiModel(value = "result is important")
public class Result {
    private String code;
    private String message;
    private Object data;
    public Result(CodeMessage codeMessage,Object data){
        this.data=data;
        this.code=codeMessage.getCode();
        this.message=codeMessage.getMessage();
    }

    public Result( String code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public Result() {
    }
    public Result(CodeMessage codeMessage) {
        this.code=codeMessage.getCode();
        this.message=codeMessage.getMessage();
    }
    public Result(CodeMessage codeMessage,String message) {
        this.code=codeMessage.getCode();
        this.message=message;
    }
    public Result(CodeMessage codeMessage,String message,Object data) {
        this.code=codeMessage.getCode();
        this.message=message;
        this.data=data;
    }
    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getServerTime() {
        return new Date();
    }
}
