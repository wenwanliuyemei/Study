package com.xm.study.reflect.presenter;

import android.content.Context;
import android.util.Log;

import com.xm.study.reflect.model.*;
import com.xm.study.reflect.view.ITestReflectView;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 作者：xm on 2017/1/3 16:11
 * 描述：
 */
public class TestFelectPresenterCompl implements ITestFelectPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private final String CLASS_NAME = "com.xm.study.reflect.model.UserCompl";
    private final String CLASS_NAME_APPLE = "com.xm.study.reflect.model.AppleCompl";
    private final String METHOD_1 = "method1";
    private final String METHOD_2 = "method2";
    private Context mContext;
    private ITestReflectView mITestReflectView;

    public TestFelectPresenterCompl(Context context, ITestReflectView iITestReflectView) {
        mContext = context;
        mITestReflectView = iITestReflectView;
    }

    @Override
    public void reflect() {
        //通过一个对象获得完整的包名和类名
        Log.e(TAG, "getName()=" + mContext.getClass().getName());
        //com.xm.study.reflect.TestReflectActivity
        Log.e(TAG, "getSimpleName()=" + mContext.getClass().getSimpleName());
        //TestReflectActivity
        mITestReflectView.reflectDone();
    }

    @Override
    public void init() {
        //实例化Class类对象
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // 一般采用这种形式
        try {
            class1 = Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        class2 = new UserCompl("xm", "xm").getClass();
        class3 = UserCompl.class;
        Log.e(TAG, "类名称=" + class1.getName());
        Log.e(TAG, "类名称=" + class2.getName());
        Log.e(TAG, "类名称=" + class3.getName());
        //类名称=com.xm.study.reflect.model.UserCompl
        //类名称=com.xm.study.reflect.model.UserCompl
        //类名称=com.xm.study.reflect.model.UserCompl
        mITestReflectView.initDone();
    }

    @Override
    public void getSuperClassInterface() {
        //获取一个对象的父类与实现的接口
        Class<?> clazz = null;
        try {
            clazz = Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 取得父类
        Class<?> parentClass = clazz.getSuperclass();
        Log.e(TAG, "UserCompl的父类为:" + parentClass.getName());
        // UserCompl的父类为:java.lang.Object
        // 获取所有的接口
        Class<?> intes[] = clazz.getInterfaces();
        Log.e(TAG, "UserCompl实现的接口有：");
        for (int i = 0; i < intes.length; i++) {
            Log.e(TAG, (i + 1) + "：" + intes[i].getName());
        }
        // UserCompl实现的接口有：
        // 1：com.xm.study.reflect.model.IUser
        // 2：java.io.Serializable
        mITestReflectView.getSuperClassInterfaceDone();
    }

    @Override
    public void getObject() {
        //通过反射机制实例化一个类的对象
        Class<?> class1 = null;
        try {
            class1 = Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 第一种方法，实例化默认构造方法，调用set赋值
        UserCompl userCompl = null;
        try {
            userCompl = (UserCompl) class1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        userCompl.setPasswd("0");
        userCompl.setName("name0");
        Log.e(TAG, userCompl.toString());
        // 结果 name=name0,passwd=0
        // 第二种方法 取得全部的构造函数 使用构造函数赋值
        Constructor<?> cons[] = class1.getConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            Log.e(TAG, "cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    Log.e(TAG, clazzs[j].getName());
                else
                    Log.e(TAG, clazzs[j].getName() + ",");
            }
            Log.e(TAG, ")");
        }
        // 结果
        // cons[0] ()
        // cons[1] (java.lang.String)
        // cons[2] (java.lang.String, java.lang.String)
        try {
            userCompl = (UserCompl) cons[1].newInstance((Object) "name1");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Log.e(TAG, userCompl.toString());
        // 结果 name=name1,passwd=
        try {
            userCompl = (UserCompl) cons[2].newInstance("name2", "2");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Log.e(TAG, userCompl.toString());
        // 结果 name=name2,passwd=2
        mITestReflectView.getObjectDone();
    }

    @Override
    public void getAttribute() {
        //获取某个类的全部属性
        Class<?> clazz = null;
        try {
            clazz = Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "本类属性=");
        // 取得本类的全部属性
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            Log.e(TAG, priv + " " + type.getName() + " " + field[i].getName() + ";");
        }
        //private static final long serialVersionUID;
        //private final java.lang.String TAG;
        //private java.lang.String name;
        //private java.lang.String passwd;
        Log.e(TAG, "实现的接口或者父类的属性=");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            Log.e(TAG, priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }
        mITestReflectView.getAttributeDone();
    }

    @Override
    public void getAllMethod() {
        //获取某个类的全部方法
        Class<?> clazz = null;
        try {
            clazz = Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method method[] = clazz.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            Log.e(TAG, Modifier.toString(temp) + " ");
            Log.e(TAG, returnType.getName() + "  ");
            Log.e(TAG, method[i].getName() + " ");
            Log.e(TAG, "(");
            for (int j = 0; j < para.length; ++j) {
                Log.e(TAG, para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    Log.e(TAG, ",");
                }
            }
            // public boolean equals (java.lang.Object arg0)
            // public final native java.lang.Class getClass ()
            // public java.lang.String getName ()
            // public java.lang.String getPasswd ()
            // public native int hashCode ()
            // public void method1 ()
            // public void method2 ()
            // public final native void notify ()
            // public final native void notifyAll ()
            // public java.lang.String say (java.lang.String arg0, java.lang.String arg1)
            // public void setName (java.lang.String arg0)
            // public void setPasswd (java.lang.String arg0)
            // public java.lang.String toString ()
            // public final void wait ()throws java.lang.InterruptedException
            // public final void wait (long arg0)throws java.lang.InterruptedException
            // public final native void wait (long arg0, int arg1)throws java.lang.InterruptedException
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                Log.e(TAG, ") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    Log.e(TAG, exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        Log.e(TAG, ",");
                    }
                }
            } else {
                Log.e(TAG, ")");
            }
        }
        mITestReflectView.getAllMethodDone();
    }

    @Override
    public void getOneMethod() {
        //通过反射机制调用某个类的方法
        Class<?> clazz = null;
        try {
            clazz = Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method method = null;
        try {
            method = clazz.getMethod(METHOD_1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "method1:getMethod");
        try {
            method.invoke(clazz.newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "method1:invoke");
        // method1:getMethod
        // method1
        // method1:invoke
        try {
            method = clazz.getMethod(METHOD_2, String.class, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "method2:getMethod");
        try {
            method.invoke(clazz.newInstance(), "name3", "3");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "method2:invoke");
        // method2:getMethod
        // method2:name=name3,passwd=3
        // method2:invoke
        mITestReflectView.getOneMethodDone();
    }

    @Override
    public void getOneAttribute() {
        //通过反射机制操作某个类的属性
        Class<?> clazz = null;
        try {
            clazz = Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 可以直接对 private 的属性赋值
        Field field = null;
        try {
            field = clazz.getDeclaredField("name");//属性名
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            field.set(obj, "Java反射机制");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            Log.e(TAG, "" + field.get(obj));
         //Java反射机制
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mITestReflectView.getOneAttributeDone();
    }

    @Override
    public void proxy() {
        //反射机制的动态代理
        MyInvocationHandler demo = new MyInvocationHandler();
        IUser iUser = (IUser) demo.bind(new UserCompl());
        String info = iUser.say("name4", "4");
        Log.e(TAG, info);
        //name=name4,passwd=4
        mITestReflectView.proxyDone();
    }

    @Override
    public void intListPutString() {
        //在泛型为Integer的ArrayList中存放一个String类型的对象。
        ArrayList<Integer> list = new ArrayList<Integer>();
        Method method = null;
        try {
            method = list.getClass().getMethod("add", Object.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(list, "Java反射机制实例。");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "" + list.get(0));
        //Java反射机制实例。
        mITestReflectView.intListPutStringDone();
    }

    @Override
    public void updateArray() {
        //通过反射取得并修改数组的信息
        int[] temp = {1, 2, 3, 4, 5};
        Class<?> demo = temp.getClass().getComponentType();
        Log.e(TAG, "数组类型： " + demo.getName());
        Log.e(TAG, "数组长度  " + Array.getLength(temp));
        Log.e(TAG, "数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        Log.e(TAG, "修改之后数组第一个元素为： " + Array.get(temp, 0));
        //数组类型： int
        //数组长度  5
        //数组的第一个元素: 1
        //修改之后数组第一个元素为： 100
        mITestReflectView.updateArrayDone();
    }

    @Override
    public void upaateArraySize() {
        //通过反射机制修改数组的大小
        int[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] newTemp = (int[]) arrayInc(temp, 15);
        print(newTemp);
        String[] atr = {"a", "b", "c"};
        String[] str1 = (String[]) arrayInc(atr, 8);
        print(str1);
        //数组长度为： 15
        //数组长度为： 8
    }

    @Override
    public void fruitFactory() {
        //将反射机制应用于工厂模式
        /**
         * 对于普通的工厂模式,当添加一个子类的时候，就需要对应的修改工厂类。 当添加很多的子类的时候，会很麻烦。
         * 现在利用反射机制实现工厂模式，可以在不修改工厂类的情况下添加任意多个子类。
         * 但是有一点仍然很麻烦，就是需要知道完整的包名和类名，这里可以使用properties配置文件来完成。
         */
        IFruit iFruit = FruitFactory.getInstance(CLASS_NAME_APPLE);
        if (iFruit != null) {
            iFruit.eat();
        }
        //AppleCompl
        mITestReflectView.fruitFactoryDone();
    }

    // 修改数组大小
    public Object arrayInc(Object obj, int len) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, len);
        int co = Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }

    // 打印
    public void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }
        Log.e(TAG, "数组长度为： " + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
        System.out.println();
    }
}
