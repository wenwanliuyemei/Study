package com.xm.study.easechat.main.presenter;

import android.content.Context;

import com.xm.study.easechat.main.view.IECMainView;

/**
 * Created by zhangxiumei on 2017/4/11.
 */

public class ECMainPresenterCompl implements IECMainPresenter {

    private final String TAG = this.getClass().getSimpleName();

    private Context mContext;
    private IECMainView mIECMainView;

    public ECMainPresenterCompl(Context context, IECMainView iecMainView) {
        mContext = context;
        mIECMainView = iecMainView;
    }

}
