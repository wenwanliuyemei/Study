package com.xm.study.thread.model;

/**
 * 作者：xm on 2017/2/23 17:16
 * 描述：
 */
public class ThreadVolatile {
    public volatile static int count=0;
    public static void inc(){
        //延迟1毫秒，使结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
}
