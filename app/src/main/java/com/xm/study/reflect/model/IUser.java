package com.xm.study.reflect.model;

/**
 * 作者：xm on 2017/1/3 17:21
 * 描述：
 */
public interface IUser {
    public String getName();
    public void setName(String name);
    public String getPasswd();
    public void setPasswd(String passwd);
    public String say(String name,String passwd);
}
