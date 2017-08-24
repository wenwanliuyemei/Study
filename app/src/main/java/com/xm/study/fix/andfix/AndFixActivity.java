package com.xm.study.fix.andfix;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.fix.andfix.presenter.ComplAndFixPresenter;
import com.xm.study.fix.andfix.view.IAndFixView;
import com.xm.utils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AndFixActivity extends BaseActivity implements IAndFixView {

    @Bind(R.id.tv_show_toast)
    TextView tvShowToast;
    @Bind(R.id.tv_update)
    TextView tvUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_and_fix);
        ButterKnife.bind(this);

        iPresenter = new ComplAndFixPresenter(this, this);
        ((ComplAndFixPresenter) iPresenter).setText(getResources().getString(R.string.fix_andfix_before));
    }

    @OnClick({R.id.tv_show_toast, R.id.tv_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_show_toast:
                ((ComplAndFixPresenter) iPresenter).showToast(R.string.fix_andfix_before);
                break;
            case R.id.tv_update:
                ((ComplAndFixPresenter) iPresenter).update();
                break;
        }
    }

    @Override
    public void setTextDone(String string) {
        tvShowToast.setText(string);
    }

    @Override
    public void showToastDone() {
        LogUtils.e("showToastDone");
        test();
    }

    @Override
    public void updateDone() {
        LogUtils.e("updateDone");
    }

    private void test(){
        LogUtils.e("test");
        tvShowToast.setText(getResources().getString(R.string.fix_andfix_after));
    }
}
