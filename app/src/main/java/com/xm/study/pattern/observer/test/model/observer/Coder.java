package com.xm.study.pattern.observer.test.model.observer;

import android.util.Log;

import com.xm.study.pattern.observer.test.model.observable.Observable;

/**
 * 作者：xm on 2017/2/16 14:39
 * 描述：观察者
 */
public class Coder implements Observer {

    private final String TAG=this.getClass().getSimpleName();
    private String name;

    public Coder(String name){
        this.name=name;
    }

    @Override
    public void updata(Observable observable, Object object) {
        Log.e(TAG,"Hi,"+name+",主题更新了，内容是："+object);
    }

    @Override
    public String toString() {
        return "码农："+name;
    }
}
