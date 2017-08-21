package com.xm.study.okhttp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.okhttp.constant.Constant;
import com.xm.study.okhttp.model.AD;
import com.xm.study.okhttp.model.Request;
import com.xm.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OkHttpActivity extends BaseActivity {

    @Bind(R.id.tv_okhttp_get_ad)
    TextView tvOkhttpGetAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_okhttp_get_ad)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_okhttp_get_ad:
                getAD();
                break;
        }
    }

    private void getAD() {
        Map<String, String> map = new HashMap<>();
        map.put("type", "2");
        Request.post(Constant.AD, map, OkHttpActivity.this, AD.class, true, new Request.RequestListener<AD>() {
            @Override
            public void success(AD data) {
                LogUtils.e(TAG, "success--data=" + data);
            }

            @Override
            public void successNoData(String data) {
                LogUtils.e(TAG, "successNoData--data=" + data);

            }

            @Override
            public void error(String status, String msg) {
                LogUtils.e(TAG, "error--msg=" + msg);
            }
        });
    }
}
