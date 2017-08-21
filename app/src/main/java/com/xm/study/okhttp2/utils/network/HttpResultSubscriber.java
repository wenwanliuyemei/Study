package com.xm.study.okhttp2.utils.network;

import android.content.Context;
import android.text.TextUtils;

import com.xm.study.R;
import com.xm.study.okhttp2.model.bean.HttpResult;
import com.xm.utils.LogUtils;
import com.xm.utils.ToastUtil;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/9/21.
 */
public abstract class HttpResultSubscriber<T> extends Subscriber<HttpResult<T>> {
    Context context;

    public HttpResultSubscriber(Context context) {
        this.context = context;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e.getMessage().contains("Failed")) {
            _onError(context.getResources().getString(R.string.okhttp2_network_no));
        } else if (e.toString().contains("time out")) {
            _onError(context.getResources().getString(R.string.okhttp2_network_no));
        } else {
            ToastUtil.toast(context, R.string.okhttp2_network_no);
            _onError(e.toString());
        }
        LogUtils.e(e.getMessage());
    }

    @Override
    public void onNext(HttpResult<T> t) {
        if (t != null) {
            if (!TextUtils.isEmpty(t.getStatus())) {
                if (t.getStatus().equals("1")) {
                    if (t.getData() == null) {
                        onSuccessNoData();
                    } else {
                        onSuccess(t.getData());
                    }
                } else if (t.getStatus().equals("102")) {
                    _onError("请重新登录！");
                } else {
                    if (!TextUtils.isEmpty(t.getMsg()))
                        _onError(t.getMsg());
                }
            }
        }

    }

    public abstract void onSuccess(T t);

    public abstract void _onError(String msg);

    public abstract void onSuccessNoData();
}
