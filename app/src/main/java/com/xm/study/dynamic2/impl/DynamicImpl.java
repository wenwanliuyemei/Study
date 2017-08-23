package com.xm.study.dynamic2.impl;

import com.xm.study.dynamic.Dynamic;

/**
 * @author: xm on 2017/8/21.
 * @describe:
 */

public class DynamicImpl implements Dynamic {
    @Override
    public String sayHello() {
        return new StringBuffer(getClass().getName())
                .append("is loaded by DexClassLoader").toString();
    }
}
