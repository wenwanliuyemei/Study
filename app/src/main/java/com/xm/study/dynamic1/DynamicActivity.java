package com.xm.study.dynamic1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.dynamic1.presenter.ComplDynamicPresenter;
import com.xm.study.dynamic1.view.IDynamicView;
import com.xm.utils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DynamicActivity extends BaseActivity implements IDynamicView {

    @Bind(R.id.tv_dynamic_load)
    TextView tvDynamicLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        ButterKnife.bind(this);
        iPresenter = new ComplDynamicPresenter(this, this);
    }

    @OnClick(R.id.tv_dynamic_load)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dynamic_load:
                ((ComplDynamicPresenter)iPresenter).loadDexClass();
                break;
        }
    }

    @Override
    public void loadDexClassDone() {
        LogUtils.e("loadDexClassDone");
    }
}
