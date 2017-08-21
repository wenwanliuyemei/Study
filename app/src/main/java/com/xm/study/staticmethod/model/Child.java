package com.xm.study.staticmethod.model;

import android.util.Log;

/**
 * 作者：xm on 2017/3/16 15:06
 * 描述：
 */
public class Child extends Father {

    private final static String TAG = "Child";

    public static int a = getB();

    static {
        Log.e(TAG, "Child static");
    }

    public Child() {
        Log.e(TAG, "Child Child ");
    }

    private static int getB() {
        Log.e(TAG, "Child getB ");
        return 0;
    }
}
