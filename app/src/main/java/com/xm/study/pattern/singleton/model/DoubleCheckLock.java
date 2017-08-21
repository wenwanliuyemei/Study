package com.xm.study.pattern.singleton.model;

/**
 * 作者：xm on 2017/2/14 10:02
 * 描述：DCL： instance=new DoubleCheckLock();这行的代码，分3个原子操作；
 * 1、分配内存，2、调用构造函数，初始化，3、引用指向内存；
 * 2、3的顺序是不固定的，1-2-3、1-3-2都可以；
 * 当线程一按后者执行，在3执行完毕、2未执行之前，切换到线程二上，instance不为空，线程二直接使用此对象，则会出错。
 * private volatile static DoubleCheckLock instance=null;若添加volatile后，就可以按1-2-3顺序执行了。
 */
public class DoubleCheckLock {
    private static DoubleCheckLock instance = null;
    private DoubleCheckLock() {
    }
    public static DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLock.class) {
                if (instance == null) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
