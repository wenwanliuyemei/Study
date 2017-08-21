package com.xm.study.home.presenter;

/**
 * 作者：xm on 2017/1/3 11:33
 * 描述：
 */
public interface IHomePresenter {
    public void loadDatas();

    public void onItemClick(int position);

    public void itemEmptyView();
}
