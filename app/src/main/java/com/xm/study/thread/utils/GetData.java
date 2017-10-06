package com.xm.study.thread.utils;

import com.xm.utils.LogUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: xm on 2017/10/6.
 * @describe: 有时一个任务开启一个线程执行，需要等待数据返回再进行处理，
 * 但又希望主线程可以继续跑下去。这时可以使用Future进行处理。
 */

public class GetData {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<String> getData() {
        return executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                LogUtils.e("my data!");
                return "hello world!";
            }
        });
    }
}
