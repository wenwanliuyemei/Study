package com.xm.study.genericity.model.complexmodel;

import java.util.ArrayList;

/**
 * 作者：xm on 2017/2/3 17:36
 * 描述：
 */
public class Aisle extends ArrayList<Shelf> {

    public Aisle(int shelves, int products) {
        for (int i = 0; i < shelves; i++) {
            add(new Shelf(products));
        }
    }
}
