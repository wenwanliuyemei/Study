package com.xm.study.pattern.singleton.model;

/**
 * 作者：xm on 2017/2/13 17:12
 * 描述：对象：private、static、直接new。（饿汉模式）
 * private的构造函数。
 * public、static的get方法。
 * 在加载类后，就会创建实例。
 * 当实例创建需要依赖参数或配置文件时，在getInstance（）前需要调用某种方法配置参数，则此方法不合适。
 */
public class DirectNew {
    private static DirectNew instance = new DirectNew();

    private DirectNew() {

    }

    public static DirectNew getInstance() {
        return instance;
    }
}
