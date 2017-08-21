package com.xm.study.pattern.factory.model.standard;


import com.xm.study.pattern.factory.model.phone.IProductPhone;

/**
 * 作者：xm on 2017/2/15 17:45
 * 描述：抽象的工厂接口或基类。
 * 通过此接口或类实现真实的工厂类。
 * 标准工厂：一个工厂只能生产一个产品，所以此处需要2个工厂。
 */
public abstract interface IStandardFactoryPhone {

    public abstract IProductPhone getPhone();
}
