package com.xm.study.pattern.observer.order.presenter;

import android.content.Context;

import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;

/**
 * @author: xm on 2017/7/28.
 * @describe:
 */

public class ComplPresenterObserverOeder extends ComplPresenter implements IPresenterObserverOrder {

    public ComplPresenterObserverOeder(Context context, IView iView) {
        super(context, iView);
    }
}