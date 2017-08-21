package com.xm.study.pattern.singleton.model;

/**
 * 作者：xm on 2017/2/13 17:33
 * 描述：懒汉式.
 * get方法外部加锁，每次调用get方法都会同步，即使已经new了对象，消耗不必要的资源。
 */
public class IfNull2 {
    private static IfNull2 instance;
    private IfNull2(){}

    public static synchronized IfNull2 getInstance(){
        if(instance==null){
            instance=new IfNull2();
        }
        return instance;
    }
}
