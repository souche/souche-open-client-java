package com.souche.open.response;

import java.io.Serializable;

public abstract class BaseResponse  implements Serializable {
    private static final long serialVersionUID = 1720022455003682613L;

    private Integer code = 200;
    private Integer status = 200;
    private String msg = "";
    private String body = "";

    public boolean isSuccess() {
        return this.code == 200;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
