package com.xm.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：xm on 2017/1/3 15:17
 * 描述：
 */
public class ToastUtil {
    public static void toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toast(Context context, int msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
