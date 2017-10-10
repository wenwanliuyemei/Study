package com.xm.study.components.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import com.xm.study.components.presenter.ComplComponentsPre.MsgReceiverByBroadcast;


public class MsgServiceByBroadcast extends Service {

    public static final int MAX_PROGRESS = 100;//进度条的最大值
    private int progress = 0;//进度条的进度值
    public static final String ACTION = "components.service.ByBroadcast";
    private Intent intent = new Intent(MsgReceiverByBroadcast.ACTION);

    /**
     * 模拟下载任务，每秒钟更新一次
     */
    public void startDownLoad() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (progress < MAX_PROGRESS) {
                    progress += 20;
                    Bundle bundle=new Bundle();
                    bundle.putInt(MsgReceiverByBroadcast.WHAT,MsgReceiverByBroadcast.BY_BROADCAST);
                    bundle.putInt(MsgReceiverByBroadcast.PROGRESS,progress);
                    intent.putExtras(bundle);
                    sendBroadcast(intent);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startDownLoad();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
