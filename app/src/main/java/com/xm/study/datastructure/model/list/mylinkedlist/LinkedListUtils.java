package com.xm.study.datastructure.model.list.mylinkedlist;

/**
 * @author: xm on 2017/12/25.
 * @describe:
 */

public class LinkedListUtils {


    /**
     * 递归，在反转当前节点之前先反转后续节点
     *
     * @param head
     */
    public static LinkedListNode reversedLinkedList(LinkedListNode head) {
        //head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        //若为空链或者当前结点在尾结点，则直接还回
        if (head == null || head.getNext() == null) {
            return head;
        }
        LinkedListNode reHead = reversedLinkedList(head.getNext());//先反转后续节点head.getNext()
        head.getNext().setNext(head);//将当前结点的指针域指向前一结点
        head.setNext(null);//前一结点的指针域令为null;
        return reHead;//反转后新链表的头结点
    }
}
