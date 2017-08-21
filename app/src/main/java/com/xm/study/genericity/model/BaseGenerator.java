package com.xm.study.genericity.model;

import com.xm.study.genericity.model.interfacee.IGenerator;

/**
 * 作者：xm on 2017/1/18 18:01
 * 描述：
 */
public class BaseGenerator<T> implements IGenerator<T> {

    private Class<T> type;

    public BaseGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> IGenerator<T> create(Class<T> type) {
        return new BaseGenerator<T>(type);
    }
}
