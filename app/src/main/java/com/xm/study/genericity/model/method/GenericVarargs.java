package com.xm.study.genericity.model.method;

import java.util.List;

/**
 * 作者：xm on 2017/1/18 16:49
 * 描述：
 */
public class GenericVarargs {
    public static <T> List<T> makeList(T...args){
        List<T> result=New.list();
        for (T item:args){
            result.add(item);
        }
        return result;
    }
}
