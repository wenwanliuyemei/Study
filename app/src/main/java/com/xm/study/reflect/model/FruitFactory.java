package com.xm.study.reflect.model;

/**
 * Created by zhangxiumei on 2017/1/4.
 * 工厂模式
 */

public class FruitFactory {
    public static IFruit getInstance(String className){
        IFruit iFruit=null;
        try {
            iFruit=(IFruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return iFruit;
    }
}
