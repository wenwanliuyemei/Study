package com.xm.study.genericity.model.coffee;

/**
 * 作者：xm on 2017/1/13 17:26
 * 描述：
 */
public class Coffee {
    private static long counter=0;
    private final long id=counter++;
    public String toString(){
        return getClass().getSimpleName()+" "+id;
    }
}
