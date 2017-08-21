package com.xm.study.pattern.singleton.model;

/**
 * 作者：xm on 2017/2/15 10:23
 * 描述：静态内部类
 * InnerClassHolder私有，除getInstance（）外没有办法访问它；
 * 读取它时，不会同步，消耗不必要的资源，没有性能缺陷；
 */
public class InnerClass {

    private InnerClass() {
    }

    public static InnerClass getInstance(){
        return InnerClassHolder.innerClass;
    }

    private static class InnerClassHolder {
        private static InnerClass innerClass = new InnerClass();
    }
}
