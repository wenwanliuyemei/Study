package com.xm.study.upwardtransiton.model;

import android.util.Log;

/**
 * 作者：xm on 2017/3/16 10:47
 * 描述：
 */
public class Father {

    private final String TAG = this.getClass().getSimpleName();

    public String name = "father";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void methodBoth() {
        Log.e(TAG, "methodBoth--father=" + this.getClass());
    }

    public void methodFatherOnly() {
        Log.e(TAG, "methodFatherOnly--father=" + this.getClass());
    }
}
