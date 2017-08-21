package com.xm.study.recyclerview.xrecyclerview.presenter;

import com.xm.study.base.IPresenter;

/**
 * Created by zhangxiumei on 2017/5/8.
 */

public interface IPresenterXRecycleview extends IPresenter {

    public void initData();

    public void initRefreshData();

    public void initLoadMoreData();
}
