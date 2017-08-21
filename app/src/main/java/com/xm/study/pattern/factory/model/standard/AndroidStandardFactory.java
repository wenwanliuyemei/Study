package com.xm.study.pattern.factory.model.standard;

import com.xm.study.pattern.factory.model.phone.AndroidPhone;
import com.xm.study.pattern.factory.model.phone.IProductPhone;

/**
 * 作者：xm on 2017/2/15 18:03
 * 描述：
 */
public class AndroidStandardFactory implements IStandardFactoryPhone {

    @Override
    public IProductPhone getPhone() {
        return new AndroidPhone();
    }
}
