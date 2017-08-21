package com.xm.study.notification.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by zhangxiumei on 2017/6/1.
 */

public class Utils {
    /**
     * 获取默认的pendingIntent,为了防止2.3及以下版本报错。
     * flags属性: 在顶部常驻:Notification.FLAG_ONGOING_EVENT。
     * 点击去除： Notification.FLAG_AUTO_CANCEL。
     */
    public static PendingIntent getDefalutIntent(Context context, int flags) {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, new Intent(), flags);
        return pendingIntent;
    }
}
