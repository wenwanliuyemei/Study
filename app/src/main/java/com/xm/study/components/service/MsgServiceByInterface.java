package com.xm.study.components.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.xm.study.components.model.OnProgressListener;

public class MsgServiceByInterface extends Service {

    public static final int MAX_PROGRESS = 100;//进度条的最大值
    private int progress = 0;//进度条的进度值
    private OnProgressListener onProgressListener;//更新进度的回调接口

    /**
     * 注册回调接口的方法，供外部调用
     *
     * @param onProgressListener
     */
    public void setOnProgressListener(OnProgressListener onProgressListener) {
        this.onProgressListener = onProgressListener;
    }

    /**
     * 增加get()方法，供Activity调用
     *
     * @return 下载进度
     */
    public int getProgress() {
        return progress;
    }

    /**
     * 模拟下载任务，每秒钟更新一次
     */
    public void startDownLoad() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (progress < MAX_PROGRESS) {
                    progress += 10;

                    //进度发生变化通知调用方
                    if (onProgressListener != null) {
                        onProgressListener.onProgress(progress);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }


    /**
     * 返回一个Binder对象
     */
    @Override
    public IBinder onBind(Intent intent) {
        return new MsgBinder();
    }

    public class MsgBinder extends Binder {
        /**
         * 获取当前Service的实例
         *
         * @return
         */
        public MsgServiceByInterface getService() {
            return MsgServiceByInterface.this;
        }
    }
}
