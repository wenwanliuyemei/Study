package com.xm.study.recyclerview.recyclerview.presenter;

import com.xm.study.base.IPresenter;
import com.xm.study.recyclerview.recyclerview.model.AppInfo;

import java.util.ArrayList;

/**
 * @author: xm on 2017/8/1.
 * @describe:
 */

public interface IPresenterRecyclerView extends IPresenter{

    public void getAppInfos(ArrayList<AppInfo> appInfos,int size);
}
