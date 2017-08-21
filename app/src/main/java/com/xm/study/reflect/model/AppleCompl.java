package com.xm.study.reflect.model;

import android.util.Log;

/**
 * Created by zhangxiumei on 2017/1/4.
 */

public class AppleCompl implements IFruit {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void eat() {
        Log.e(TAG, "AppleCompl");
    }
}
