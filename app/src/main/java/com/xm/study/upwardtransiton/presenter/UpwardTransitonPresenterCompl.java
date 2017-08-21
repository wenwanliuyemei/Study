package com.xm.study.upwardtransiton.presenter;

import android.content.Context;
import android.util.Log;

import com.xm.study.upwardtransiton.model.Father;
import com.xm.study.upwardtransiton.model.Son;
import com.xm.study.upwardtransiton.view.IUpwardTransitionView;

/**
 * 作者：xm on 2017/3/16 10:12
 * 描述：
 */
public class UpwardTransitonPresenterCompl implements IUpwardTransitonPresenter {

    private final String TAG = this.getClass().getSimpleName();

    private Context context;
    private IUpwardTransitionView iUpwardTransitionView;

    public UpwardTransitonPresenterCompl(Context context, IUpwardTransitionView iUpwardTransitionView) {
        this.context = context;
        this.iUpwardTransitionView = iUpwardTransitionView;
    }

    @Override
    public void upwardTransiton() {
        Father father = new Son();
        Log.e(TAG, "this.class()=" + this.getClass());
        father.methodBoth();//子类方法、Son:methodBoth--son=class com.xm.study.upwardtransiton.model.Son
        father.methodFatherOnly();//父类方法、Son:methodFatherOnly--father=class com.xm.study.upwardtransiton.model.Son
        Log.e(TAG, "father--name=" + father.name);//父类name、UpwardTransitonPresenterCompl: father--name=father
        Log.e(TAG, "father--getName()=" + father.getName());//子类name、UpwardTransitonPresenterCompl: father--getName()=son

        Son son = (Son) father;//向下转型，编译、运行不会出错
        son.methodBoth();//子类、Son: methodBoth--son=class com.xm.study.upwardtransiton.model.Son
        son.methodSonOnly();//子类、Son: methodSonOnly--son=class com.xm.study.upwardtransiton.model.Son
        son.methodFatherOnly();//父类、Son: methodFatherOnly--father=class com.xm.study.upwardtransiton.model.Son
        Log.e(TAG, "son--instanceof--name=" + son.name);//子类name、UpwardTransitonPresenterCompl: son--instanceof--name=son
        Log.e(TAG, "son--instanceof--getName()=" + son.getName());//子类name、UpwardTransitonPresenterCompl: son--instanceof--getName()=son

        Father father2 = new Father();
        //Son son2=(Son)father2;//编译出错
        //son2.methodBoth();
        //son2.methodSonOnly();
        //son2.methodFatherOnly();
        if (father2 instanceof Son) {
            Son son2 = (Son) father2;//编译出错
            son2.methodBoth();
            son2.methodSonOnly();
            son2.methodFatherOnly();
            Log.e(TAG, "instanceof--name=" + son.name);//子类name
            Log.e(TAG, "instanceof--getName()=" + son.getName());//子类name
        } else {
            Log.e(TAG, "father2 is not instanceof Son.");//子类name
        }
        iUpwardTransitionView.upwardTransitonDone();
    }
}
