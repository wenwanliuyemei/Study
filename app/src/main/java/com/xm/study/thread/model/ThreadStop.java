package com.xm.study.thread.model;

import android.util.Log;

/**
 * Created by zhangxiumei on 2017/2/22.
 */

public class ThreadStop implements Runnable {

    private final String TAG=this.getClass().getSimpleName();
    private boolean stop=false;

    @Override
    public void run() {
        for (int i=0;i<100&&!stop;i++){
            Log.e(TAG,"currentThread="+Thread.currentThread().getName()+" "+i);
        }
    }

    public void stopThread(boolean stop){
        this.stop=stop;
    }
}

