package com.xm.study.dataalgorithm.model.stack;

import com.xm.study.dataalgorithm.model.list.Link;
import com.xm.study.dataalgorithm.model.list.LinkList;
import com.xm.utils.LogUtils;

/**
 * @author: xm on 2018/1/29.
 * @describe:
 */

public class LinkStack {

    private LinkList linkList;

    public LinkStack() {
        linkList = new LinkList();
    }

    public void push(int id, double dd) {
        linkList.insertFirst(id, dd);
    }

    public Link pop() {
        return linkList.deleteFirst();
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void displayLinkStack() {
        LogUtils.e("LinkStack(top-->botoom):");
        linkList.displayLinkList();
    }
}
