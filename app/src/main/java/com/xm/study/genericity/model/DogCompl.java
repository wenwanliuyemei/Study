package com.xm.study.genericity.model;

import com.xm.study.genericity.model.interfacee.IAnimal;

/**
 * Created by zhangxiumei on 2017/1/5.
 */

public class DogCompl extends AnimalCompl implements IAnimal {

    public DogCompl(String name, int age) {
        super(name, age);
    }
}
