package com.xm.study.pattern.observer.exit.presenter;

import com.xm.study.base.IPresenter;
import com.xm.study.pattern.observer.exit.model.ApplicationObservable;

/**
 * @author: xm on 2017/7/28.
 * @describe:
 */

public interface IPresenterObserverExit extends IPresenter {

    public void close(ApplicationObservable applicationObservable,Object data);
}
