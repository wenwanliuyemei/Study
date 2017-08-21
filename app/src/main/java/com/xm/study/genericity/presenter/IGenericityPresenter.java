package com.xm.study.genericity.presenter;

/**
 * Created by zhangxiumei on 2017/1/5.
 * 泛型
 */

public interface IGenericityPresenter<A, B> {

    public void getAnimal();

    public void getTwoTuple(A a, B b);

    public void getLinkedStackCompl();

    public void getRandomList();

    public void getCoffee();

    public void getFibonacci();

    public void getIterableFibonacci();

    public void getGenericMethod();

    public void getGenericMethodNew();

    public void getGenericVarargs();

    public void getMethodGenerators();

    public void getBaseGenerator();

    public void getTupleNew();

    public void getWatercolors();

    public void getSetNew(Class<?> superSet, Class<?> subSet);

    public void innerClass();

    public void complexmodel();
}
