package com.xm.study.okhttp2.model.bean;

/**
 * Created by Administrator on 2016/9/21.
 */
public class HttpResult<T> {
    private String status, msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    private T data;
}
