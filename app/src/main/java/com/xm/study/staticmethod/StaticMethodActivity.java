package com.xm.study.staticmethod;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.staticmethod.presenter.IStaticMethodPresenter;
import com.xm.study.staticmethod.presenter.StaticMethodPresenterCompl;
import com.xm.study.staticmethod.view.IStaticMethodView;

public class StaticMethodActivity extends BaseActivity implements IStaticMethodView {

    private final String TAG = this.getClass().getSimpleName();
    private IStaticMethodPresenter iStaticMethodPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_method);

        // init view、set listener
        int[] ids = new int[]{R.id.tv_static_method_hello_world, R.id.tv_static_method_child};
        View[] views = new View[ids.length];
        initViewAndSetListener(views, ids);

        //init
        iStaticMethodPresenter = new StaticMethodPresenterCompl(this, this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_static_method_hello_world:
                iStaticMethodPresenter.helloWorld();
                break;
            case R.id.tv_static_method_child:
                iStaticMethodPresenter.child();
                break;
        }
    }

    @Override
    public void helloWorldDone() {
        Log.e(TAG, "helloWorldDone");
    }

    @Override
    public void childDone() {
        Log.e(TAG, "childDone");
    }
}
