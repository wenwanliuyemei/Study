package com.xm.study.notification.notification;

import android.content.Context;
import android.support.v7.app.NotificationCompat;

import com.xm.study.notification.utils.MyNotificationManager;

/**
 * Created by zhangxiumei on 2017/6/1.
 */

public class MyNotification implements INotification {

    public Context mContext;
    public static MyNotificationManager mMyNotificationManager;
    public NotificationCompat.Builder mBuilder;

    public MyNotification(Context context) {
        mContext = context;
        if(mMyNotificationManager==null){
            mMyNotificationManager = new MyNotificationManager(context);
        }
        mBuilder = new NotificationCompat.Builder(mContext);
    }
}
