package com.xm.study.datastructure.model.list;

import com.xm.utils.LogUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 * Created by zhangxiumei on 2017/7/21.
 */

public class MyLinkedList {

    private static final String TAG = "MyLinkedList";

    private List list = null;

    public static void a() {
        List list = Collections.synchronizedList(new LinkedList());
        List arrayList = new ArrayList();
        int newSize = (arrayList.size() * 3) / 2 + 1;
        ((ArrayList) arrayList).ensureCapacity(newSize);

        list();

        set();

        hashMap();

        hashTable();

        treeMap();
    }

    private static void set() {
        TreeSet<Object> treeSet = new TreeSet<Object>();

//        treeSet.add(new Integer(5));
//        treeSet.add(new Integer(1));
        treeSet.add("pp");
        treeSet.add("pa");
        treeSet.add("aa");
        treeSet.add("ad");
        treeSet.add("g");
        treeSet.add("10");
        treeSet.add("1");

        for (Object object:treeSet){
            LogUtils.e(TAG, "treeSet"+object.toString());
        }

        Iterator iterator=treeSet.iterator();
        while (iterator.hasNext()){
            LogUtils.e(TAG, "treeSet"+iterator.next());
        }

        TreeSet treeSet2 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object lhs, Object rhs) {
                Student student1 = (Student) lhs;
                Student student2 = (Student) rhs;
                int result = student1.compareTo(student2);
                return student1.compareTo(student2);
            }
        });
        treeSet2.add(new Student("10", 100));
        treeSet2.add(new Student("5", 60));
        treeSet2.add(new Student("2", 80));
        treeSet2.add(new Student("3", 40));
        treeSet2.add(new Student("4", 60));

        LogUtils.e(TAG, treeSet2.toString());
    }

    private static void list() {
        String[] strTemp = {"cc", "dd", "ee", "ff"};
        List<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < strTemp.length; i++) {
            arrayList.add(strTemp[i]);
        }
        //for
        for (int i = 0; i < arrayList.size(); i++) {
            LogUtils.e(TAG, "arrayList[" + i + "]=" + arrayList.get(i));
        }
        //foreach
        for (String string : arrayList) {
            LogUtils.e(TAG, "arrayList=" + string);
        }
        //Iterator
        Iterator iterator=arrayList.iterator();
        while (iterator.hasNext()){
            LogUtils.e(TAG, "arrayList=" + iterator.next());
        }

        Vector vector = new Vector();
        vector.add(0.99f);
        vector.add("aa");
        vector.add(true);
        vector.add(new Integer(99));
        vector.add(new String[]{"bb"});
        vector.add(new Boolean(false));
        vector.addElement(strTemp);
        for (int i = 0; i < strTemp.length; i++) {
            vector.addElement(strTemp[i]);
        }
        LogUtils.e(TAG, vector.toString());

        Enumeration enumeration = vector.elements();
        Object objTemp = null;
        while (enumeration.hasMoreElements()) {
            objTemp = enumeration.nextElement();
            LogUtils.e(TAG, objTemp.toString());
        }
    }

    private static void treeMap() {
        TreeMap<String, String> tmp = new TreeMap<String, String>();
        tmp.put("d", "cdc");
        tmp.put("c", "ccc");
        tmp.put("a", "aaa");
        tmp.put("b", "bbb");
        Iterator<String> iterator = tmp.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            LogUtils.e(TAG, "tmp.get(key) is :"+key+":" + tmp.get(key));
        }
    }

    private static void hashTable() {
        String[] subjects = {"语文", "数学", "英语", "政治"};
        String[] scores = {"88", "90", "98", "80"};
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < subjects.length; i++) {
            hashtable.put(subjects[i], scores[i]);
        }
        Enumeration enumeration2 = hashtable.keys();
        Object object2 = null;
        while (enumeration2.hasMoreElements()) {
            object2 = enumeration2.nextElement();
            LogUtils.e(TAG, "Hashtable=" + object2);
        }
    }

    private static void hashMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            LogUtils.e(TAG, "key:" + entry.getKey());
            LogUtils.e(TAG, "value:" + entry.getValue());
        }
        String value1 = (String) map.get("key1");
        LogUtils.e(TAG, "key1的value：" + (String) map.get("key1"));

        Set<String> sett = map.keySet();
        for (String s : sett) {
            LogUtils.e(TAG,s+":"+map.get(s));
        }

    }
}
