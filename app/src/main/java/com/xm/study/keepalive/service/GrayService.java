package com.xm.study.keepalive.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import com.xm.study.base.Consts;

/**
 * @author: xm on 2017/9/27.
 * @describe: APP灰色保活
 */

public class GrayService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //API < 18,此方法能有效地隐藏notification的图标
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(Consts.ServiceId.GRAY_SERVICE_ID, new Notification());
        } else {
            Intent intent1 = new Intent(this, GrayInnerService.class);
            startService(intent1);
            startForeground(Consts.ServiceId.GRAY_SERVICE_ID, new Notification());
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
