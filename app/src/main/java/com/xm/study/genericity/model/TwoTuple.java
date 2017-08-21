package com.xm.study.genericity.model;

/**
 * Created by zhangxiumei on 2017/1/6.
 * 泛型
 */

public class TwoTuple<A, B> {

    private final String TAG = this.getClass().getSimpleName();
    //return语句只允许返回单个对象。
    //元组：可以返回一组对象。
    //元组：将一组对象直接打包存储于其中一个单一对象。
    // 元组的要求：允许读取其中的元素，不允许向其中存放新的对象。
    //元组可以具有任意的长度，元组中的对象可以具有任意不同的类型。
    // 处理不同长度的问题，需要创建多个不同的元组。
    //声明为public、final，并没有声明为private、然后用get、set处理；
    //这样处理的目的是：A、B初始化后，不能再修改A、B代表的对象的类型；
    // 如果想修改，只能重新创建一个新的TwoTuple对象。
    //只需要定义一个长度合适的元组，将其作为方法的返回值，return语句创建该元组并返回即可。

    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}
