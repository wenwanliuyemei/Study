package com.xm.study.thread.model;

import android.util.Log;

/**
 * 作者：xm on 2017/2/17 15:59
 * 描述：多线程。
 * 3个线程，共享100张火车票。
 */
public class ThreadImplementsTicket2 implements Runnable{
    private final String TAG=this.getClass().getSimpleName();
    private final int TICKETS=100;
    private int tickets=100;//每个线程共享100张火车票

    @Override
    public void run() {
        while(tickets>0){
            tickets--;
            Log.e(TAG,(TICKETS-tickets)+" is saled by "+Thread.currentThread().getName());
        }
    }
}
