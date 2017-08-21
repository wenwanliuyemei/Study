package com.xm.study.easechat.chat.presenter;

import android.content.Context;

import com.xm.study.easechat.chat.view.IECChatView;

/**
 * Created by zhangxiumei on 2017/4/11.
 */

public class ECChatPresenterCompl implements IECChatPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private Context mContext;
    private IECChatView mIECChatView;

    public ECChatPresenterCompl(Context context, IECChatView iecChatView) {
        mContext = context;
        mIECChatView = iecChatView;
    }
}
