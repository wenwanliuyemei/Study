package com.xm.study.genericity.model.method;

import android.util.Log;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 作者：xm on 2017/1/19 16:41
 * 描述：
 */
public class SetNew {

    //合并
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    //共有部分
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    //前者特有的
    public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet) {
        Set<T> result = new HashSet<T>(superSet);
        result.removeAll(subSet);
        return result;
    }

    //二者交集之外的
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    public static Set<String> methodSet(Class<?> type) {
        Set<String> result = New.treeSet();
        for (Method method : type.getMethods()) {
            result.add(method.getName());
        }
        return result;
    }

    public static void interfaces(Class<?> type) {
        List<String> result = New.list();
        for (Class<?> cl : type.getInterfaces()) {
            result.add(cl.getSimpleName());
        }
        Log.e("SetNew", "Interfaces in " + type.getSimpleName() + ":" + result);
    }
}
