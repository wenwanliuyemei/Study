package com.xm.study.thread.utils;

import com.xm.utils.LogUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: xm on 2017/10/6.
 * @describe: http://blog.csdn.net/z83986976/article/details/52107978
 */
public class LogService {

    private final BlockingQueue<String> queue;

    private final LoggerThread logger;

    //关闭标记
    private volatile boolean isShutDown;

    public void start() {
        logger.start();
    }

    public void stop() {
        isShutDown = true;
        logger.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        queue.put(msg);
    }

    public LogService() {
        queue = new LinkedBlockingQueue<String>();
        logger = new LoggerThread();
    }

    private class LoggerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    if (isShutDown)
                        break;
                    LogUtils.e(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
