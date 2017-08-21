package com.xm.study.pattern.observer.order;

import android.os.Bundle;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.pattern.observer.order.presenter.ComplPresenterObserverOeder;
import com.xm.study.pattern.observer.order.view.IViewObserverOrder;

public class ObserverOrderActivity extends BaseActivity implements IViewObserverOrder {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_order);

        iPresenter = new ComplPresenterObserverOeder(this, this);
    }
}
