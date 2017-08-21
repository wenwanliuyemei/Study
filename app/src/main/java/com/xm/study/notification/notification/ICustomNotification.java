package com.xm.study.notification.notification;

/**
 * Created by zhangxiumei on 2017/5/31.
 */

public interface ICustomNotification extends INotification {

    public void pre();

    public void play();

    public void next();

    public void register();

    public void unregister();
}
