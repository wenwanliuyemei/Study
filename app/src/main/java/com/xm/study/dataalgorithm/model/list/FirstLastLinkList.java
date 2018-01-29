package com.xm.study.dataalgorithm.model.list;

import com.xm.utils.LogUtils;

/**
 * @author: xm on 2018/1/25.
 * @describe: 双端链表，对最后一个结点的引用，就如对第一个结点的引用
 */

public class FirstLastLinkList {

    private Link first;
    private Link last;

    public FirstLastLinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link link = new Link(id, dd);
        if (isEmpty()) {
            last = link;//link<--last(last指向新结点)
        }
        link.next = first;//link-->old first(新结点指向旧first)
        first = link;//first-->link(first指向新结点)
        LogUtils.e("insertFirst");
    }

    public void insertLast(int id, double dd) {
        Link link = new Link(id, dd);
        if (isEmpty()) {
            first = link;//first-->link
        } else {
            last.next = link;//old last-->link
        }
        last = link;//link<--last
        LogUtils.e("insertLast");
    }

    public int deleteFirst() {
        int temp = first.iData;
        if (first.next == null) {
            last = null;//null<--last
        }
        first = first.next;//first-->old next
        LogUtils.e("deleteFirst");
        return temp;
    }

    public void displayFirstLastLinkList() {
        LogUtils.e("FirstLastLinkList(first-->last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}
