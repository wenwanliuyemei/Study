package com.xm.study.genericity.model;

import android.util.Log;

import com.xm.study.genericity.model.interfacee.INode;

/**
 * 作者：xm on 2017/1/9 17:14
 * 描述：
 */
public class NodeCompl<U> implements INode{
    private final String TAG=this.getClass().getSimpleName();
    public U item;
    public NodeCompl<U> next;
    public NodeCompl(){
        item=null;
        next=null;
    }

    public NodeCompl(U item,NodeCompl<U> next){
        this.item=item;
        this.next=next;
        Log.e(TAG,"NodeCompl---item="+item);
        //NodeCompl---item=Phasers
        //NodeCompl---item=or
        //NodeCompl---item=stun!
        Log.e(TAG,"NodeCompl---next="+next);
        //NodeCompl---next=com.xm.study.genericity.model.NodeCompl@34ef40a1
        // NodeCompl---next=com.xm.study.genericity.model.NodeCompl@d15c2c6
        //NodeCompl---next=com.xm.study.genericity.model.NodeCompl@1ec07287
    }

    public boolean end(){
        return item==null&&next==null;
    }
}
