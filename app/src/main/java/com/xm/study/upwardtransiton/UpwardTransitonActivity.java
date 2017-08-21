package com.xm.study.upwardtransiton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.upwardtransiton.presenter.IUpwardTransitonPresenter;
import com.xm.study.upwardtransiton.presenter.UpwardTransitonPresenterCompl;
import com.xm.study.upwardtransiton.view.IUpwardTransitionView;

public class UpwardTransitonActivity extends BaseActivity implements IUpwardTransitionView {

    private final String TAG = this.getClass().getSimpleName();
    private IUpwardTransitonPresenter iUpwardTransitonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upward_transiton);

        //init view、set listener
        int[] ids = new int[]{R.id.tv_upward_transition_1};
        View[] views = new View[ids.length];
        initViewAndSetListener(views, ids);

        //init
        iUpwardTransitonPresenter = new UpwardTransitonPresenterCompl(this, this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_upward_transition_1:
                iUpwardTransitonPresenter.upwardTransiton();
                break;
        }
    }

    @Override
    public void upwardTransitonDone() {
        Log.e(TAG, "upwardTransitonDone");
    }
}
