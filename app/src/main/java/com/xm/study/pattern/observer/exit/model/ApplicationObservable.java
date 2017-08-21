package com.xm.study.pattern.observer.exit.model;

import java.util.Observable;

/**
 * @author: xm on 2017/7/28.
 * @describe: 被观察者，即主题。
 * 主题变化，更新所有观察者。
 */

public class ApplicationObservable extends Observable {


    /**
     * 退出应用
     */
    public void exit() {
        setChanged();
        notifyObservers();
    }

    /**
     * 退出应用
     * @param data
     */
    public void exit(Object data) {
        setChanged();
        notifyObservers(data);
    }
}
