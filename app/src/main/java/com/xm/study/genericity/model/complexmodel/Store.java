package com.xm.study.genericity.model.complexmodel;

import java.util.ArrayList;

/**
 * 作者：xm on 2017/2/3 17:39
 * 描述：复杂模型
 */
public class Store extends ArrayList<Aisle> {

    private ArrayList<CheckoutStand> checkoutStandArrayList = new ArrayList<>();
    private Office office = new Office();

    public Store(int aisles, int shelves, int products) {
        for (int i = 0; i < aisles; i++) {
            add(new Aisle(shelves, products));
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Aisle aisle : this) {
            for (Shelf shelf : aisle) {
                for (Product product : shelf) {
                    stringBuilder.append(product);
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}
