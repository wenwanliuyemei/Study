package com.xm.study.pattern.factory.presenter;

import android.content.Context;

import com.xm.study.pattern.factory.model.phone.IProductPhone;
import com.xm.study.pattern.factory.model.simple.SimpleFactoryPhone;
import com.xm.study.pattern.factory.model.standard.AndroidStandardFactory;
import com.xm.study.pattern.factory.model.standard.IStandardFactoryPhone;
import com.xm.study.pattern.factory.model.standard.IosStandardFactory;
import com.xm.study.pattern.factory.view.IFactoryPatternView;


/**
 * Created by zhangxiumei on 2017/2/15.
 */

public class FactoryPatternPresenterCompl implements IFactoryPatternPresenter {

    private final String TAG=this.getClass().getSimpleName();
    private Context context;
    private IFactoryPatternView iFactoryPatternView;

    public FactoryPatternPresenterCompl(Context context,IFactoryPatternView iFactoryPatternView) {
        this.context = context;
        this.iFactoryPatternView = iFactoryPatternView;
    }

    @Override
    public void standardPhone() {
        IProductPhone android,ios;
        IStandardFactoryPhone androidFactory,iosFactory;
        androidFactory=new AndroidStandardFactory();
        iosFactory=new IosStandardFactory();
        android=androidFactory.getPhone();
        ios=iosFactory.getPhone();
        android.getOS();
        ios.getOS();
        iFactoryPatternView.standardPhoneDone();
    }

    @Override
    public void simplePhone() {
        IProductPhone android,ios;
        android=SimpleFactoryPhone.getPhone(SimpleFactoryPhone.ANDROID);
        ios=SimpleFactoryPhone.getPhone(SimpleFactoryPhone.IOS);
        android.getOS();
        ios.getOS();
        iFactoryPatternView.simplePhoneDone();
    }
}
