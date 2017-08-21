package com.xm.study.okhttp2.model.bean;

/**
 * Created by zhangxiumei on 2017/6/28.
 */

public class UpdateBean<T> {

    private int update;
    private int ret;
    private String verNo;
    private String update_info;
    private String description;
    private String created_at;
    private int forceUpdate;
    private String org;
    private String msg;
    private String url;
    private String version;

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getVerNo() {
        return verNo;
    }

    public void setVerNo(String verNo) {
        this.verNo = verNo;
    }

    public String getUpdate_info() {
        return update_info;
    }

    public void setUpdate_info(String update_info) {
        this.update_info = update_info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(int forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "UpdateBean{" +
                "update=" + update +
                ", ret=" + ret +
                ", verNo='" + verNo + '\'' +
                ", update_info='" + update_info + '\'' +
                ", description='" + description + '\'' +
                ", created_at='" + created_at + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", org='" + org + '\'' +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
