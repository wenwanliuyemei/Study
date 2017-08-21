package com.xm.study.handler.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.xm.study.R;

/**
 * @author: xm on 2017/8/11.
 * @describe:
 */

public class MessageUtils {

    public static void sendMessageMsg(Context context, String str, int what, Handler hanler) {
        sendMessage(context, str + context.getResources().getString(R.string.handler_thread_msg), what, hanler);
    }

    public static void sendMessage(Context context, String str, int what, Handler hanler) {
        Message message = new Message();
        message.what = what;
        message.obj = str + context.getResources().getString(R.string.handler_thread_msg);
        hanler.sendMessage(message);
    }
}
