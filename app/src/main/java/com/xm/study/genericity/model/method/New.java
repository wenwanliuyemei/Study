package com.xm.study.genericity.model.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 作者：xm on 2017/1/18 15:35
 * 描述：
 */
public class New {

    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> linkedList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> hashSet() {
        return new HashSet<T>();
    }

    public static <T> Set<T> treeSet() {
        return new TreeSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }
}
