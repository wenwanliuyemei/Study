package com.xm.study.genericity.model.method;

import android.util.Log;

/**
 * 作者：xm on 2017/1/18 14:59
 * 描述：泛型方法
 */
public class GenericMethods {

    private final String TAG=this.getClass().getSimpleName();

    public <T> void f(T t){
        Log.e(TAG,t.getClass().getName());
    }
}
