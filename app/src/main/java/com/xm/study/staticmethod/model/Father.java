package com.xm.study.staticmethod.model;

import android.util.Log;

/**
 * 作者：xm on 2017/3/16 15:06
 * 描述：
 */
public class Father {
    private final static String TAG = "Parent";

    static {
       Log.e(TAG, "Parent static");
    }

    public static int a = getA();

    public Father() {
       Log.e(TAG, "Parent Parent ");
    }

    private static int getA() {
       Log.e(TAG, "Parent getA ");
        return 0;
    }
}
