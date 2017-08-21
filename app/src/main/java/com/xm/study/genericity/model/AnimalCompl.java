package com.xm.study.genericity.model;

import android.util.Log;

import com.xm.study.genericity.model.interfacee.IAnimal;

/**
 * 作者：xm on 2017/1/6 15:06
 * 描述：
 */
public class AnimalCompl implements IAnimal {

    private final String TAG=this.getClass().getSimpleName();
    private String name;
    private int age;

    public AnimalCompl(String name,int age ){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        Log.e(TAG,"getName---name="+name);
        return name;
    }

    public void setName(String name) {
        Log.e(TAG,"setName---old name="+this.name+",new name="+name);
        this.name = name;
    }

    public int getAge() {
        Log.e(TAG,"getAge---age="+age);
        return age;
    }

    public void setAge(int age) {
        Log.e(TAG,"setAge---old age="+this.age+",new age="+age);
        this.age = age;
    }
}
