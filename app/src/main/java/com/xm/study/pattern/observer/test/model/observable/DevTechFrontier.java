package com.xm.study.pattern.observer.test.model.observable;

/**
 * 作者：xm on 2017/2/16 15:11
 * 描述：主题，被观察者。
 * 技术论坛，有更新时会通知所有观察者，即所有程序员会接到相应的通知。
 */
public class DevTechFrontier extends Observable {

    public void newContent(String content){
        setChanged();
        notifyObservers(content);
    }
}
