package com.xm.utils;

import android.content.Context;
import android.content.Intent;

/**
 * @author: xm on 2017/8/2.
 * @describe:
 */

public class IntentUtils {

    public static void intent(Context context, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
    }
}
