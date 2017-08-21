package com.xm.study.genericity.model.innerclass;

import com.xm.study.genericity.model.interfacee.IGenerator;

/**
 * 作者：xm on 2017/2/3 10:47
 * 描述：
 */
public class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    public String toString() {
        return "Customer " + id;
    }

    public static IGenerator<Customer> generator() {
        return new IGenerator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}
