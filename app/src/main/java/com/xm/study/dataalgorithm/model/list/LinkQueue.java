package com.xm.study.dataalgorithm.model.list;

import com.xm.utils.LogUtils;

/**
 * @author: xm on 2018/1/29.
 * @describe: 用链表实现的队列
 */

public class LinkQueue {

    private FirstLastLinkList firstLastLinkList;

    public LinkQueue() {
        firstLastLinkList = new FirstLastLinkList();
    }

    public boolean isEmpty() {
        return firstLastLinkList.isEmpty();
    }

    public void insert(int id, double dd) {
        firstLastLinkList.insertLast(id, dd);
    }

    public long remove() {
        return firstLastLinkList.deleteFirst();
    }

    public void dispalyQueue() {
        LogUtils.e("LinkQueue(front-->rear):");
        firstLastLinkList.displayFirstLastLinkList();
    }
}
