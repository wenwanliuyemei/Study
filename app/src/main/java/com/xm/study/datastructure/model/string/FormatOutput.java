package com.xm.study.datastructure.model.string;

import android.util.Log;

/**
 * 作者：xm on 2017/2/8 15:32
 * 描述：格式输出
 */
public class FormatOutput {

    public static void printf(int x, double y) {
        System.out.printf("printf:[%d %f]\n", x, y);
    }

    public static void printf(float x, double y) {
        System.out.printf("printf:[%f %f]\n", x, y);
    }

    public static void format(int x, float y) {
        System.out.format("format:[%d %f]\n", x, y);
        Log.e("format", String.format("format:[%d %f]\n", x, y));
    }

    public static void format(float x, double y) {
        System.out.format("format:[%f %f]\n", x, y);
        Log.e("format", String.format("format:[%f %f]\n", x, y));
    }
}
