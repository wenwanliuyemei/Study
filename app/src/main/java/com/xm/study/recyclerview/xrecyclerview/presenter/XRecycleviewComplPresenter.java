package com.xm.study.recyclerview.xrecyclerview.presenter;

import android.content.Context;

import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.recyclerview.xrecyclerview.view.IViewXRecycleview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiumei on 2017/5/9.
 */

public class XRecycleviewComplPresenter extends ComplPresenter implements IPresenterXRecycleview {

    public XRecycleviewComplPresenter(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void initData() {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<String> url = new ArrayList<>();
            url.add("http://g.hiphotos.baidu.com/image/pic/item/c75c10385343fbf25431e823b27eca8065388f95.jpg");
            url.add("http://g.hiphotos.baidu.com/image/pic/item/960a304e251f95ca2f34115acd177f3e6609521d.jpg");
            lists.add(url);
        }
        ((IViewXRecycleview) iView).initData(lists);
    }

    @Override
    public void initRefreshData() {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            List<String> url = new ArrayList<>();
            url.add("http://qq1234.org/uploads/allimg/140404/3_140404114606_1.jpg");
            url.add("http://qq1234.org/uploads/allimg/140404/3_140404114555_6.jpg");
            lists.add(url);
        }
        ((IViewXRecycleview) iView).initRefreshData(lists);
    }

    @Override
    public void initLoadMoreData() {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<String> url = new ArrayList<>();
            url.add("http://qq1234.org/uploads/allimg/140404/3_140404114555_5.jpg");
            url.add("http://qq1234.org/uploads/allimg/140404/3_140404114555_4.jpg");
            lists.add(url);
        }
        ((IViewXRecycleview) iView).initLoadMoreData(lists);
    }
}
