package com.xm.study.genericity.model;

import android.util.Log;

import com.xm.study.genericity.model.interfacee.IRandomList;

import java.util.ArrayList;
import java.util.Random;

/**
 * 作者：xm on 2017/1/13 16:15
 * 描述：
 */
public class RandomListCompl<T> implements IRandomList{
    private final String TAG=this.getClass().getSimpleName();
    private ArrayList<T> storage=new ArrayList<T>();
    private Random random=new Random(47);
    public void add(T item){
        storage.add(item);
    }

    public T select(){
        Log.e(TAG,"storage.size()="+storage.size());
        //storage.size()=9
        int id=random.nextInt(storage.size());
        Log.e(TAG,"id="+id);
        //id=2、id=8、id=4
        T t=storage.get(id);
        Log.e(TAG,"t="+t);
        //t=brown、t=dog、t=jumped
        return t;
    }
}
