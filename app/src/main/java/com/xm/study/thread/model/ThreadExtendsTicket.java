package com.xm.study.thread.model;

import android.util.Log;

/**
 * 作者：xm on 2017/2/17 15:59
 * 描述：多线程。
 * 3个线程，卖不同类型的电影票。
 */
public class ThreadExtendsTicket extends Thread {
    private final String TAG = this.getClass().getSimpleName();
    private final int TICKETS = 100;
    private int tickets = 100;//每个线程都有100张票

    public ThreadExtendsTicket() {
    }

    public ThreadExtendsTicket(String name) {
        super(name);
    }

    public ThreadExtendsTicket(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        while (tickets > 0) {
            tickets--;
            Log.e(TAG, (TICKETS - tickets) + " is saled by " + Thread.currentThread().getName());
        }
    }
}
