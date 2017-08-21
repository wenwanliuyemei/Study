package com.xm.study.genericity.model.innerclass;

import com.xm.study.genericity.model.interfacee.IGenerator;

/**
 * 作者：xm on 2017/2/3 10:59
 * 描述：
 */
public class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    public String toString() {
        return "Teller " + id;
    }

    public static IGenerator<Teller> generator = new IGenerator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}
