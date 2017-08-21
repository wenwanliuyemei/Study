package com.xm.study.genericity.model;

/**
 * 作者：xm on 2017/1/19 11:17
 * 描述：
 */
public class CountedObject {
    private final String TAG=this.getClass().getSimpleName();
    private static long counter=0;
    private final long id=counter++;

    public long getId(){
        return id;
    }

    public String toString(){
        return TAG+" "+id;
    }
}
