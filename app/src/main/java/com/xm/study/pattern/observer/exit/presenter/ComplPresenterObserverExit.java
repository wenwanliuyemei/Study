package com.xm.study.pattern.observer.exit.presenter;

import android.content.Context;

import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.pattern.observer.exit.model.ApplicationObservable;
import com.xm.study.pattern.observer.exit.view.IViewObserverExit;

/**
 * @author: xm on 2017/7/28.
 * @describe:
 */

public class ComplPresenterObserverExit extends ComplPresenter implements IPresenterObserverExit {

    public ComplPresenterObserverExit(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void close(ApplicationObservable applicationObservable,Object data) {
        applicationObservable.exit(data);
        ((IViewObserverExit) iView).colseDone();
    }
}
