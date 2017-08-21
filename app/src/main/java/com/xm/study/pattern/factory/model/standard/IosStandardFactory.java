package com.xm.study.pattern.factory.model.standard;


import com.xm.study.pattern.factory.model.phone.IProductPhone;
import com.xm.study.pattern.factory.model.phone.IosPhone;
/**
 * 作者：xm on 2017/2/15 18:04
 * 描述：
 */
public class IosStandardFactory implements IStandardFactoryPhone {

    @Override
    public IProductPhone getPhone() {
        return new IosPhone();
    }
}
