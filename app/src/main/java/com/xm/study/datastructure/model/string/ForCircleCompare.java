package com.xm.study.datastructure.model.string;

import android.util.Log;

/**
 * 作者：xm on 2017/2/8 10:11
 * 描述：String、StringBuilder、StringBuffer的比较
 */
public class ForCircleCompare {

    public static String stringForCircle(String[] strings) {
        long beginTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result += strings[i];
        }
        long endTime = System.currentTimeMillis();
        Log.e("stringForCircle", "time=" + (endTime - beginTime));
        return result;
    }

    public static String stringBuilderForCircle(String[] strings) {
        long beginTime = System.currentTimeMillis();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
        }
        long endTime = System.currentTimeMillis();
        Log.e("stringBuilderForCircle", "time=" + (endTime - beginTime));
        return result.toString();
    }

    public static String stringBufferForCircle(String[] strings) {
        long beginTime = System.currentTimeMillis();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
        }
        long endTime = System.currentTimeMillis();
        Log.e("stringBufferForCircle", "time=" + (endTime - beginTime));
        return result.toString();
    }
}
