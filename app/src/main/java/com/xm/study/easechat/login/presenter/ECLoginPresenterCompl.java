package com.xm.study.easechat.login.presenter;

import android.content.Context;

import com.xm.study.easechat.login.view.IECLoginView;

/**
 * Created by zhangxiumei on 2017/4/11.
 */

public class ECLoginPresenterCompl implements IECLoginPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private Context mContext;
    private IECLoginView mIECLoginView;

    public ECLoginPresenterCompl(Context context, IECLoginView iecLoginView) {
        mContext = context;
        mIECLoginView = iecLoginView;
    }
}
