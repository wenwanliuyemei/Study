package com.xm.study.pattern.observer.test.model.observer;

import com.xm.study.pattern.observer.test.model.observable.Observable;

/**
 * 作者：xm on 2017/2/16 14:44
 * 描述：
 */
public interface Observer {

    public void updata(Observable observable,Object object);
}
