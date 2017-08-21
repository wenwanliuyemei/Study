package com.xm.study.datastructure.model.string;

/**
 * 作者：xm on 2017/2/8 15:07
 * 描述：无意识的递归--内存地址
 */
public class MemoryAddress {
    @Override
    public String toString() {
        //return "MemoryAddress="+this;//报错
        return "MemoryAddress="+super.toString();
    }
}
