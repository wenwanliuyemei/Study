package com.xm.study.datastructure.model.list.mylinkedlist;

/**
 * @author: xm on 2017/12/25.
 * @describe: http://blog.csdn.net/guyuealian/article/details/51119499
 */

public class LinkedListUtils {


    /**
     * 递归，在反转当前节点之前先反转后续节点
     *
     * @param head
     * @return
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

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     *
     * @param head
     * @return
     */
    public static LinkedListNode reversedLinkedList2(LinkedListNode head) {
        if (head == null)
            return head;
        LinkedListNode pre = head;// 上一结点
        LinkedListNode cur = head.getNext();// 当前结点
        LinkedListNode tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }
}
