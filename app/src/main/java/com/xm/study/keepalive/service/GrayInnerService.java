package com.xm.study.keepalive.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.xm.study.base.Consts;

/**
 * @author: xm on 2017/9/27.
 * @describe: 给API >= 18 的平台上做灰色保护手段
 */

public class GrayInnerService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(Consts.ServiceId.GRAY_SERVICE_ID, new Notification());
        stopForeground(true);
        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }
}