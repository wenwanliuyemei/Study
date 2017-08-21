package com.xm.study.genericity.model.coffee;

import android.util.Log;

import com.xm.study.genericity.model.interfacee.IGenerator;

import java.util.Iterator;
import java.util.Random;

/**
 * 作者：xm on 2017/1/13 17:21
 * 描述：
 */
public class CoffeeGeneratorCompl implements IGenerator, Iterable<Coffee> {

    private final String TAG = this.getClass().getSimpleName();
    private Class[] types = {LatteCoffee.class, MochaCoffee.class, CappuccinoCoffee.class,
            AmericanoCoffee.class, BreveCoffee.class};
    //Random rand = new Random(47);
    //47作为起源数字，并不一定代表后面的数字范围。
    //47是一个产生随机数的魔法数字，这个问题到现在都没人能够解释，
    //只是经过很多次试验得到的，由47做种后，产生的随机数更加体现了随机性。
    //它没有什么具体的意义，只要理解随机数如果有一个种子，出现了比较随即的随机数，
    //而当种子是47的时候，随即率是最大的。
    //Random随机生成的各种数字都是均匀的机会，每个对象同一次数产生的数字相同。
    private static Random random = new Random(47);
    private int size = 0;

    public CoffeeGeneratorCompl() {
    }

    public CoffeeGeneratorCompl(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            int i = random.nextInt(types.length);
            Log.e(TAG, "Coffee next()---i=" + i);
            return (Coffee) types[i].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            @Override
            public boolean hasNext() {
                return (size > 0);
            }

            @Override
            public Coffee next() {
                size--;
                return CoffeeGeneratorCompl.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
