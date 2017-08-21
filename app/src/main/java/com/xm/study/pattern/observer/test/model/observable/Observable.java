package com.xm.study.pattern.observer.test.model.observable;

import com.xm.study.pattern.observer.test.model.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：xm on 2017/2/16 14:45
 * 描述：主题，变化后主动通知所有观察者
 */
public class Observable {
    List<Observer> observers=new ArrayList<>();
    boolean changed=false;

    public Observable(){

    }

    public void addObserver(Observer observer){
        if(observer==null){
            throw new NullPointerException("observer==null");
        }
        synchronized (this){
            if(!observers.contains(observer)){
                observers.add(observer);
            }
        }
    }

    protected void clearChanged(){
        changed=false;
    }

    public boolean hasChanged(){
        return changed;
    }

    public void setChanged(){
        changed=true;
    }

    public int countObservers(){
        return observers.size();
    }

    public synchronized void deleteObserver(Observer observer){
        observers.remove(observer);
    }

    public synchronized void deleteObservers(){
        observers.clear();
    }

    public void notifyObservers(){
        notifyObservers(null);
    }

    public void notifyObservers(Object data){
        int size=0;
        Observer[] arrays=null;
        synchronized (this){
            if(hasChanged()){
                clearChanged();
                size=observers.size();
                arrays=new Observer[size];
                observers.toArray(arrays);
            }
        }
        if(arrays!=null){
            for (Observer observer:arrays){
                observer.updata(this,data);
            }
        }
    }
}
