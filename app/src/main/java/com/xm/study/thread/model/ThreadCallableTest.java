package com.xm.study.thread.model;

import android.util.Log;

import java.util.concurrent.Callable;

/**
 * 作者：xm on 2017/2/22 17:53
 * 描述：
 */
public class ThreadCallableTest implements Callable<Integer> {
    private final String TAG = this.getClass().getSimpleName();
    private final int TICKETS = 100;
    private int tickets = 100;//每个线程都有100张票

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 50; i++) {
            tickets--;
            Log.e(TAG, (TICKETS - tickets) + " is saled by " + Thread.currentThread().getName());
        }
        return tickets;
    }
}
