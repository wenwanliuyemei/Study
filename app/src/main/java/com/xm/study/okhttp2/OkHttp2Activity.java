package com.xm.study.okhttp2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.okhttp2.presenter.OkHttp2ComplPresenter;
import com.xm.study.okhttp2.view.IOkHttp2View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OkHttp2Activity extends BaseActivity implements IOkHttp2View {


    @Bind(R.id.tv_okhttp2_login)
    TextView tvOkhttp2Login;
    @Bind(R.id.tv_okhttp2_update)
    TextView tvOkhttp2Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http2);
        ButterKnife.bind(this);

        iPresenter = new OkHttp2ComplPresenter(this, this);
    }

    @OnClick({R.id.tv_okhttp2_login,R.id.tv_okhttp2_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_okhttp2_login:
                ((OkHttp2ComplPresenter) iPresenter).login("15101632254", "123456");
                break;
            case R.id.tv_okhttp2_update:
                ((OkHttp2ComplPresenter) iPresenter).login("15101632254", "123456");
                break;
        }
    }

    @Override
    public void login(String content) {
        tvOkhttp2Login.setText(content);
    }

}
