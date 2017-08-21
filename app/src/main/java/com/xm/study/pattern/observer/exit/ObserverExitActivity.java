package com.xm.study.pattern.observer.exit;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.pattern.observer.exit.presenter.ComplPresenterObserverExit;
import com.xm.study.pattern.observer.exit.view.IViewObserverExit;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObserverExitActivity extends BaseActivity implements IViewObserverExit {

    @Bind(R.id.tv_pattern_observer_exit)
    TextView tvPatternObserverExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_exit);

        ButterKnife.bind(this);
        iPresenter = new ComplPresenterObserverExit(this, this);
    }

    @Override
    public void colseDone() {

    }

//    @Override
//    public void update(Observable observable, Object data) {
//        this.finish();
//        super.update(observable, data);
//
//    }

    @OnClick(R.id.tv_pattern_observer_exit)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_pattern_observer_exit:
                ((ComplPresenterObserverExit) iPresenter).close(mMyApplication.getmApplicationObservable(), getResources().getString(R.string.pattern_observer_exit));
                break;
        }
    }
}
