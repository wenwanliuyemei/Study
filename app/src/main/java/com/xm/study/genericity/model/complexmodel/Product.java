package com.xm.study.genericity.model.complexmodel;

import android.util.Log;

import com.xm.study.genericity.model.interfacee.IGenerator;

import java.util.Random;

/**
 * 作者：xm on 2017/2/3 16:55
 * 描述：
 */
public class Product {

    private final String TAG = this.getClass().getSimpleName();
    private int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        Log.e(TAG, toString());
    }

    public String toString() {
        return id + ":" + description + ",price:$" + price;
    }

    public void priceChange(double change){
        price+=change;
    }

    public static IGenerator<Product> generator=new IGenerator<Product>() {
        @Override
        public Product next() {
            Random random=new Random(47);
            return new Product(random.nextInt(1000),"Test",
                    Math.round(random.nextDouble()*1000.0+0.99));
        }
    };
}
