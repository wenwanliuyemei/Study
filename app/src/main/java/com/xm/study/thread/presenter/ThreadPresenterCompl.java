package com.xm.study.thread.presenter;

import android.content.Context;
import android.util.Log;

import com.xm.study.genericity.model.TwoTuple;
import com.xm.study.thread.model.ThreadCallableTest;
import com.xm.study.thread.model.ThreadExtendsTicket;
import com.xm.study.thread.model.ThreadImplementsTicket;
import com.xm.study.thread.model.ThreadImplementsTicket2;
import com.xm.study.thread.model.ThreadPoolTest;
import com.xm.study.thread.model.ThreadStop;
import com.xm.study.thread.model.ThreadVolatile;
import com.xm.study.thread.view.IThreadView;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 作者：xm on 2017/2/17 16:13
 * 描述：
 */
public class ThreadPresenterCompl implements IThreadPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private Context context;
    private IThreadView iThreadView;

    public ThreadPresenterCompl(Context context, IThreadView iThreadView) {
        this.context = context;
        this.iThreadView = iThreadView;
    }

    @Override
    public void threadExtendsTicket() {
        ThreadExtendsTicket multiThreadTicket1 = new ThreadExtendsTicket("name1");
        ThreadExtendsTicket multiThreadTicket2 = new ThreadExtendsTicket("name2");
        ThreadExtendsTicket multiThreadTicket3 = new ThreadExtendsTicket("name3");
        multiThreadTicket1.start();
        multiThreadTicket2.start();
        multiThreadTicket3.start();
        iThreadView.threadExtendsTicketDone();
    }

    @Override
    public void threadImplementsTicket() {
        ThreadImplementsTicket multiThreadTicketImplements1 = new ThreadImplementsTicket();
        ThreadImplementsTicket multiThreadTicketImplements2 = new ThreadImplementsTicket();
        ThreadImplementsTicket multiThreadTicketImplements3 = new ThreadImplementsTicket();
        Thread thread1 = new Thread(multiThreadTicketImplements1);
        Thread thread2 = new Thread(multiThreadTicketImplements2);
        Thread thread3 = new Thread(multiThreadTicketImplements3);
        thread1.start();
        thread2.start();
        thread3.start();
        iThreadView.threadImplementsTicketDone();
    }

    @Override
    public void threadImplementsTicket2() {
        ThreadImplementsTicket2 multiThreadTicketImplements2 = new ThreadImplementsTicket2();
        Thread thread1 = new Thread(multiThreadTicketImplements2);
        Thread thread2 = new Thread(multiThreadTicketImplements2);
        Thread thread3 = new Thread(multiThreadTicketImplements2);
        thread1.start();
        thread2.start();
        thread3.start();
        iThreadView.threadImplementsTicketDone2();
    }

    @Override
    public void threadExtendsImplementsTest() {
        Runnable runnable = new ThreadImplementsTicket();
        Thread thread = new ThreadExtendsTicket(runnable);
        thread.start();
        // E/ThreadExtendsTicket: 94 is saled by Thread-4368
        //说明：thread调用的是ThreadExtendsTicket的run()方法，不是ThreadImplementsTicket里的
        iThreadView.threadExtendsImplementsTestDone();
    }

    @Override
    public void threadCallableTest() {
        Callable<Integer> callable = new ThreadCallableTest();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable); //使用FutureTask包装ThreadCallableTest
        for (int i = 0; i < 100; i++) {
            Log.e(TAG, "currentThread=" + Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Thread thread = new Thread(futureTask);
                thread.start();
            }
        }
        Log.e(TAG, "主线程for循环执行完毕。。");
        try {
            int sum = futureTask.get();//获取ThreadCallableTest中call（）方法返回的结果
            Log.e(TAG, "sum=" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //E/ThreadCallableTest: 50 is saled by Thread-4418
        //E/ThreadPresenterCompl: sum=50
        iThreadView.threadCallableTestDone();
    }

    @Override
    public void threadStop() {
        ThreadStop threadStop = new ThreadStop();
        Thread thread = new Thread(threadStop);
        for (int i = 0; i < 100; i++) {
            Log.e(TAG, "currentThread=" + Thread.currentThread().getName() + " " + i);
            if (i == 30) {//即使i=30时，thread不一定进入运行状态，CPU决定
                thread.start();
            }
            if (i == 40) {//i=40时，threadStop里面的i不一定等于40
                threadStop.stopThread(true);
            }
            if (i == 60) {//不能唤醒程序
                threadStop.stopThread(false);
            }
        }
        iThreadView.threadStopDone();
    }

    @Override
    public void threadVolatile() {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadVolatile.inc();
                }
            }).start();
        }
        //每次运行的结果，都不一定相同，可能不是1000
        Log.e(TAG, "ThreadVolatile.count=" + ThreadVolatile.count);
        ThreadVolatile.count = 0;
        iThreadView.threadVolatileDone();
    }

    @Override
    public void threadPoolTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++) {
            ThreadPoolTest threadPoolTest = new ThreadPoolTest(i);
            threadPoolExecutor.execute(threadPoolTest);
            Log.e(TAG, "线程池中的线程数目：" + threadPoolExecutor.getPoolSize() +
                    ",队列中等待执行的任务数目：" + threadPoolExecutor.getQueue().size() +
                    ",已执行完的任务数目：" + threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
        iThreadView.threadPoolTestDone();
    }
}
