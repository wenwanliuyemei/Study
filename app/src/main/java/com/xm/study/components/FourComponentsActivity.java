package com.xm.study.components;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.components.presenter.ComplComponentsPre;
import com.xm.study.components.view.IComponentsView;
import com.xm.utils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FourComponentsActivity extends BaseActivity implements IComponentsView {

    @Bind(R.id.tv_by_binder)
    TextView tvByBinder;
    @Bind(R.id.pb_by_binder)
    ProgressBar pbByBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_components);
        ButterKnife.bind(this);
        iPresenter = new ComplComponentsPre(this, this);
        ((ComplComponentsPre) iPresenter).byBinderInit();
    }


    @OnClick(R.id.tv_by_binder)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_by_binder:
                ((ComplComponentsPre) iPresenter).byBinderDonwload();
                break;
        }
    }

    @Override
    public void byBinderInitDone() {
        LogUtils.e("byBinderInitDone");
    }

    @Override
    public void byBinderDonwloadDone() {
        LogUtils.e("byBinderDonwloadDone");
    }

    @Override
    public void byBinderShowProgress(int progress) {
        pbByBinder.setProgress(progress);
    }

    @Override
    public void byBinderUnbindDone() {
        LogUtils.e("byBinderUnbindDone");
    }


    @Override
    protected void onDestroy() {
        ((ComplComponentsPre) iPresenter).byBinderUnbind();
        super.onDestroy();
    }
}
