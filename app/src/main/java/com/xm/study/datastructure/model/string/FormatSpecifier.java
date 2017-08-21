package com.xm.study.datastructure.model.string;

import java.util.Formatter;

/**
 * 作者：xm on 2017/2/9 15:06
 * 描述：格式化说明符
 */
public class FormatSpecifier {
    private double total = 0d;
    private Formatter formatter = new Formatter(System.out);

    public void printTitle() {
        formatter.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        formatter.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        formatter.format("%-15.15s %5d %10.2f\n", name,qty,price);
        total+=price;
    }

    public void printTotal(){
        formatter.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        formatter.format("%-15s %5s %10s\n", "", "", "-----");
        formatter.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
    }
}
