package com.xm.study.recyclerview.recyclerview.presenter;

import android.content.Context;

import com.xm.study.R;
import com.xm.study.base.ComplPresenter;
import com.xm.study.base.IView;
import com.xm.study.recyclerview.recyclerview.model.AppInfo;
import com.xm.study.recyclerview.recyclerview.view.IViewRecyclerView;

import java.util.ArrayList;

/**
 * @author: xm on 2017/8/1.
 * @describe:
 */

public class ComplPresenterRecyclerView extends ComplPresenter implements IPresenterRecyclerView {

    public ComplPresenterRecyclerView(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void getAppInfos(ArrayList<AppInfo> appInfos, int size) {
        for (int i = 0; i < size; i++) {
            AppInfo info = new AppInfo();
            info.setName(context.getString(R.string.rv_appinfo_name) + i);
            info.setChecked(false);
            appInfos.add(info);
        }
        ((IViewRecyclerView)iView).getAppInfosDoen();
    }
}
