package com.xm.study.genericity.model;

import android.util.Log;

import com.xm.study.genericity.model.interfacee.ILinkedStack;

/**
 * 作者：xm on 2017/1/9 17:37
 * 描述：
 */
public class LinkedStackCompl<T> implements ILinkedStack {
    private final String TAG=this.getClass().getSimpleName();
    private NodeCompl<T> top=new NodeCompl<T>();

    public void push(T item){
        Log.e(TAG,"push---top1.item="+top.item);
        //push---top1.item=null
        //push---top1.item=Phasers
        //push---top1.item=or
        Log.e(TAG,"push---top1.next="+top.next);
        //push---top1.next=null
        //push---top1.next=com.xm.study.genericity.model.NodeCompl@34ef40a1
        //push---top1.next=com.xm.study.genericity.model.NodeCompl@d15c2c6
        top=new NodeCompl<T>(item,top);
        Log.e(TAG,"push---top2.item="+top.item);
        //push---top2.item=Phasers
        //push---top2.item=or
        //push---top2.item=stun!
        Log.e(TAG,"push---top2.next.item="+top.next);
        //push---top2.next=com.xm.study.genericity.model.NodeCompl@34ef40a1
        //push---top2.next=com.xm.study.genericity.model.NodeCompl@d15c2c6
        //push---top2.next=com.xm.study.genericity.model.NodeCompl@1ec07287
        Log.e(TAG,"push---item="+item);
        //push---item=Phasers
        //push---item=or
        //push---item=stun!
    }

    public T pop(){
        T result=top.item;
        Log.e(TAG,"pop---result="+result);
        //pop---result=stun!
        // pop---result=or
        //pop---result=Phasers
        //pop---result=null
        if(!top.end()){
            top=top.next;
        }
        Log.e(TAG,"pop---top.item="+top.item);
        // pop---top.item=or
        //pop---top.item=Phasers
        //pop---top.item=null
        //pop---top.item=null
        Log.e(TAG,"pop---top.next="+top.next);
        //pop---top.next=com.xm.study.genericity.model.NodeCompl@d15c2c6
        //pop---top.next=com.xm.study.genericity.model.NodeCompl@34ef40a1
        //pop---top.next=null
        //pop---top.next=null
        return result;
    }
}
