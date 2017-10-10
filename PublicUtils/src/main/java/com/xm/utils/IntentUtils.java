package com.xm.utils;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

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

    public static void intentService(Context context, String action, ServiceConnection conn) {
        Intent intent = new Intent(action);
        context.bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }
}
