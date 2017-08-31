package com.xm.study.fix.nuwa;

import android.content.Context;
import android.widget.Toast;

/**
 * @author: xm on 2017/8/31.
 * @describe:
 */
public class Controller {
    private Context mContext;
    private Toast mToast;

    public Controller(Context context) {
        mContext = context;
        mToast = new Toast(context);
        sayHelloToNuwa();
        useNuwaTest();
    }

    private void sayHelloToNuwa() {
        mToast.makeText(mContext, "你好，女娲", Toast.LENGTH_LONG).show();
    }

    private void useNuwaTest() {
        mToast.cancel();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.exit(-1);
            }
        }).start();
    }
}