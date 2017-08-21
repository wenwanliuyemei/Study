package com.xm.study.okhttp2.model;

import android.content.Context;


import com.xm.study.okhttp2.model.bean.HttpResult;
import com.xm.study.okhttp2.model.bean.LoginBean;
import com.xm.study.okhttp2.model.bean.UpdateBean;

import rx.Observable;


/**
 * Created by YanWei on 2017/4/10.
 */

public interface LoginModel {
    public Observable<HttpResult<LoginBean>> getUserInfo(String name, String psd, Context context);

    public Observable<UpdateBean> update(Context context);

}
