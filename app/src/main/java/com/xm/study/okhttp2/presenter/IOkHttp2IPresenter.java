package com.xm.study.okhttp2.presenter;

import com.xm.study.base.IPresenter;

/**
 * Created by zhangxiumei on 2017/6/28.
 */

public interface IOkHttp2IPresenter extends IPresenter {

    public void login(String account, String password);

    public void update();
}
