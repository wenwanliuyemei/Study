package com.xm.study.staticmethod.presenter;

import android.content.Context;

import com.xm.study.staticmethod.model.Child;
import com.xm.study.staticmethod.model.HelloWorld;
import com.xm.study.staticmethod.view.IStaticMethodView;

/**
 * 作者：xm on 2017/3/14 11:13
 * 描述：
 */
public class StaticMethodPresenterCompl implements IStaticMethodPresenter {

    private final String TAG = this.getClass().getSimpleName();

    private Context context;
    private IStaticMethodView iStaticMethodView;

    public StaticMethodPresenterCompl(Context context, IStaticMethodView iStaticMethodView) {
        this.context = context;
        this.iStaticMethodView = iStaticMethodView;
    }

    @Override
    public void helloWorld() {
        HelloWorld hello = new HelloWorld();
        hello.show();
        HelloWorld hello1 = new HelloWorld();
        hello1.test();
        HelloWorld.test();
        hello1.show();
        iStaticMethodView.helloWorldDone();
    }

    @Override
    public void child() {
        Child child = new Child();
        iStaticMethodView.childDone();
    }
}
