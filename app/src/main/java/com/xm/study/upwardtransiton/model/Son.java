package com.xm.study.upwardtransiton.model;

import android.util.Log;

/**
 * 作者：xm on 2017/3/16 10:49
 * 描述：
 */
public class Son extends Father {

    private final String TAG = this.getClass().getSimpleName();
    public String name = "son";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void methodBoth() {
        Log.e(TAG, "methodBoth--son=" + this.getClass());
    }

    public void methodSonOnly(){
        Log.e(TAG, "methodSonOnly--son=" + this.getClass());
    }
}
