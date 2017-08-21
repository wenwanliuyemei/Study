package com.xm.study.genericity.model.complexmodel;

import com.xm.study.genericity.model.method.MethodGenerators;

import java.util.ArrayList;

/**
 * 作者：xm on 2017/2/3 17:30
 * 描述：
 */
public class Shelf extends ArrayList<Product> {

    public Shelf(int products) {
        MethodGenerators.fill(this, Product.generator, products);
    }
}
