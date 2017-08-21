package com.xm.study.genericity.model.method;

import com.xm.study.genericity.model.ThreeTuple;
import com.xm.study.genericity.model.TwoTuple;

/**
 * 作者：xm on 2017/1/19 15:48
 * 描述：
 */
public class TupleNew {

    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<A, B, C>(a, b, c);
    }
}
