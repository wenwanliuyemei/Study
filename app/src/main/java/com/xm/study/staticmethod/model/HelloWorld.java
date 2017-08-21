package com.xm.study.staticmethod.model;

import android.util.Log;

public class HelloWorld {

    private static final String TAG = "HelloWorld";
    String name;
    String sex;
    static int age;

    public HelloWorld() {
        name = "tom";
        Log.e(TAG, "构造方法--name=" + name);
    }

    {
        sex = "男";
        Log.e(TAG, "初始化块--sex=" + sex);
    }

    static {
        age = 20;
        Log.e(TAG, "静态初始化块--age=" + age);
    }

    //静态方法
    public static void test() {
        age=40;
        Log.e(TAG, "静态方法--年龄=" + age);
    }

    public void show() {
        Log.e(TAG, "show--=姓名：" + name + "，性别：" + sex + "，年龄：" + age);
    }
}