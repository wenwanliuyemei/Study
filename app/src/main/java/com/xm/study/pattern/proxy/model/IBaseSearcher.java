package com.xm.study.pattern.proxy.model;

/**
 * @author: xm on 2017/7/31.
 * @describe: 抽象角色。
 * 抽象角色：声明了代理角色和具体角色的共用接口，促使可以使用具体实角色的地方都可使用代理角色。
 * 具体角色：定义代理角色所要代表的具体角色。
 * 代理角色：包含对具体角色的引用，从而可以在任何时候操作具体角色对象；代理角色提供了与具体角色相同的接口，可以方便在任何时候替代具体角色对象。
 */
public interface IBaseSearcher {

    public String doSearch(String userName, String password, String key);
}
