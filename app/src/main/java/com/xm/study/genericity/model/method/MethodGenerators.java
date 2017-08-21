package com.xm.study.genericity.model.method;

import com.xm.study.genericity.model.interfacee.IGenerator;

import java.util.Collection;

/**
 * 作者：xm on 2017/1/18 17:28
 * 描述：
 */
public class MethodGenerators {
    public static <T> Collection<T> fill(Collection<T> collection, IGenerator<T> iGenerator, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(iGenerator.next());
        }
        return collection;
    }
}
