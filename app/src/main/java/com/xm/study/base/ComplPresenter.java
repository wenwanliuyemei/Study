package com.xm.study.base;

import android.content.Context;

/**
 * Created by zhangxiumei on 2017/4/27.
 */

public class ComplPresenter implements IPresenter {

    public final String TAG=this.getClass().getSimpleName();

    public Context context;

    public IView iView;

    public ComplPresenter(Context context, IView iView){
        this.context=context;
        this.iView=iView;
    }
}
