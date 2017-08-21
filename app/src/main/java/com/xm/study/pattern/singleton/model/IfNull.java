package com.xm.study.pattern.singleton.model;

/**
 * 作者：xm on 2017/2/13 17:33
 * 描述：懒汉式.
 * 线程一运行到1，判断为空后，即将运行2；
 * 但此时JVM将CPU资源给线程二，由于线程一还没有new，instance为null，则执行new操作；
 * 之后，线程一被唤醒，它执行的仍然是new操作。
 */
public class IfNull {
    private static IfNull instance;

    private IfNull() {
    }

    public static IfNull getInstance() {
        if (instance == null) {//1
            instance = new IfNull();//2
        }
        return instance;
    }
}
