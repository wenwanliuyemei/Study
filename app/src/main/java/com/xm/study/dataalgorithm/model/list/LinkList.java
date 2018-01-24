package com.xm.study.dataalgorithm.model.list;

import com.xm.utils.LogUtils;

/**
 * @author: xm on 2018/1/24.
 * @describe:
 */

public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayLinkList() {
        LogUtils.e("LinkList(first-->last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public Link find(int key){
        Link current=first;
        while (current.iData!=key){
            if(current.next==null){
                return null;
            }else{
                current=current.next;
            }
        }
        return current;
    }

    public Link delete(int key){
        Link current=first;
        Link previous=first;
        while (current.iData!=key){
            if(current.next==null){
                return null;
            }else{
                previous=current;
                current=current.next;
            }
        }
        if(current==first){
            first=first.next;
        }else{
            previous.next=current.next;
        }
        return current;
    }
}
