package com.xm.study.pattern.observer.test.presenter;

import android.content.Context;

import com.xm.study.pattern.observer.test.model.observable.DevTechFrontier;
import com.xm.study.pattern.observer.test.model.observer.Coder;
import com.xm.study.pattern.observer.test.view.IObserverPatternView;

/**
 * 作者：xm on 2017/2/16 15:38
 * 描述：
 */
public class ObserverPatternPresenterCompl implements IObserverPatternPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private Context context;
    private IObserverPatternView iObserverPatternView;

    public ObserverPatternPresenterCompl(Context context, IObserverPatternView iObserverPatternView) {
        this.context = context;
        this.iObserverPatternView = iObserverPatternView;
    }

    @Override
    public void observerDevTechFrontier() {
        DevTechFrontier devTechFrontier=new DevTechFrontier();

        Coder coder1=new Coder("coder1");
        Coder coder2=new Coder("coder2");
        Coder coder3=new Coder("coder3");

        devTechFrontier.addObserver(coder1);
        devTechFrontier.addObserver(coder2);
        devTechFrontier.addObserver(coder3);

        devTechFrontier.newContent("新内容");
        iObserverPatternView.observerDevTechFrontierDone();
    }
}
