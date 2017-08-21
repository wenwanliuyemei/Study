package com.xm.study.genericity.model;

/**
 * 作者：xm on 2017/1/6 16:13
 * 描述：
 */
public class Life<T> {
    private T t;

    public Life(T t){
        this.t=t;
    }
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
