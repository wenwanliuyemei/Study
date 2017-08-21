package com.xm.study.genericity.model;

/**
 * Created by zhangxiumei on 2017/1/6.
 */

public class ThreeTuple<A,B,C> extends TwoTuple<A,B>{
    private final String TAG=this.getClass().getSimpleName();
    public final C third;

    public ThreeTuple(A a,B b,C c){
        super(a,b);
        third=c;
    }

    @Override
    public String toString() {
        return "("+first+","+second+","+third+")";
    }
}
