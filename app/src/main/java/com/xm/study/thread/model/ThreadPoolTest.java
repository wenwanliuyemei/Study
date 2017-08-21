package com.xm.study.thread.model;

import android.util.Log;

/**
 * Created by zhangxiumei on 2017/3/8.
 */

public class ThreadPoolTest implements Runnable {

    private final String TAG = this.getClass().getSimpleName();
    private int taskNum;

    public ThreadPoolTest(int num) {
        taskNum = num;
    }

    @Override
    public void run() {
        Log.e(TAG, "正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "task " + taskNum + "执行完成");
    }
}
