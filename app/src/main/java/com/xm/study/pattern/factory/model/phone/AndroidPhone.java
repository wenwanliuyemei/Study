package com.xm.study.pattern.factory.model.phone;

import android.util.Log;

/**
 * 作者：xm on 2017/2/15 17:02
 * 描述：
 */
public class AndroidPhone implements IProductPhone {

    private final String TAG=this.getClass().getSimpleName();

    @Override
    public void getOS() {
        Log.e(TAG,TAG);
    }
}
