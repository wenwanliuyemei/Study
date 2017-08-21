package com.xm.study.reflect.model;

import android.util.Log;

import java.io.Serializable;

/**
 * 作者：xm on 2017/1/3 17:22
 * 描述：
 */
public class UserCompl implements IUser, Serializable {
    private static final long serialVersionUID = -2862585049955236662L;
    private final String TAG = this.getClass().getSimpleName();
    private String name = "";
    private String passwd = "";

    public UserCompl() {
    }

    public UserCompl(String name) {
        this.name = name;
    }

    public UserCompl(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String say(String name, String passwd) {
        return "name=" + name + ",passwd=" + passwd;
    }

    @Override
    public String toString() {
        return "name=" + name + ",passwd=" + passwd;
    }

    public void method1(){
        Log.e(TAG,"method1");
    }

    public void method2(String name,String passwd){
        Log.e(TAG,"method2:name=" + name + ",passwd=" + passwd);
    }
}
