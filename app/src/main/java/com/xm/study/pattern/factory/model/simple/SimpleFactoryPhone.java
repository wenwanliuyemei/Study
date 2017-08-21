package com.xm.study.pattern.factory.model.simple;

import com.xm.study.pattern.factory.model.phone.AndroidPhone;
import com.xm.study.pattern.factory.model.phone.IProductPhone;
import com.xm.study.pattern.factory.model.phone.IosPhone;

/**
 * 作者：xm on 2017/2/16 11:22
 * 描述：简单工厂模式，又名静态工厂模式。
 * 工厂不能通过继承或行扩展，如有新增产品，只能在静态方法里修改。
 * 工厂类没有接口或基类提供抽象，只能通过不同的Falg来初始化不同产品。
 */
public class SimpleFactoryPhone {

    public final static String IOS="ios";
    public final static String ANDROID="android";

    public static IProductPhone getPhone(String  flag){
        IProductPhone iProductPhone=null;
        switch (flag){
            case IOS:
                iProductPhone=new IosPhone();
                break;
            case ANDROID:
                iProductPhone=new AndroidPhone();
                break;
        }
        return iProductPhone;
    }
}
