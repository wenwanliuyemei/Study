package com.xm.study.notification.utils;

import android.app.NotificationManager;
import android.content.Context;

/**
 * Created by zhangxiumei on 2017/5/31.
 */

public class MyNotificationManager {

    /**
     * Notification管理
     */
    public NotificationManager mNotificationManager;

    private Context mContext;

    public MyNotificationManager(Context context) {
        mContext = context;
        initService();
    }

    /**
     * 初始化要用到的系统服务
     */
    private void initService() {
        mNotificationManager = (NotificationManager) mContext.getSystemService(mContext.NOTIFICATION_SERVICE);
    }

    /**
     * 清除当前创建的通知栏
     */
    public void clearNotify(int notifyId) {
        mNotificationManager.cancel(notifyId);//删除一个特定的通知ID对应的通知
//		mNotification.cancel(getResources().getString(R.string.app_name));
    }

    /**
     * 清除所有通知栏
     */
    public void clearAllNotify() {
        mNotificationManager.cancelAll();// 删除你发的所有通知
    }
}
