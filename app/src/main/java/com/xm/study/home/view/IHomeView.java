package com.xm.study.home.view;

import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * 作者：xm on 2017/1/3 11:29
 * 描述：
 */
public interface IHomeView {
    public void onGetDataList(List<String> dataList);

    public void toast(String msg);

    public void itemEmptyView(View loadingView, RelativeLayout.LayoutParams layoutParams);

}
