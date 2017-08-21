package com.xm.study.recyclerview.xrecyclerview.view;

import com.xm.study.base.IView;

import java.util.List;

/**
 * Created by zhangxiumei on 2017/5/9.
 */

public interface IViewXRecycleview extends IView {

    public void initData(List<List<String>> lists);

    public void initRefreshData(List<List<String>> lists);

    public void initLoadMoreData(List<List<String>> lists);
}