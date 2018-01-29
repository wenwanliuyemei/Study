package com.xm.study.dataalgorithm.model.list;

import android.content.Context;

import com.xm.utils.LogUtils;

/**
 * @author: xm on 2017/12/26.
 * @describe:
 */

public class LinkedListUtils {

    /**
     * <pre>
     * 题目大意
     * 有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，
     * 即第一个结点表示最低位，最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。
     *
     * 解题思路
     * 对两个链表都从第一个开始处理，进行相加，结果再除以10求商，作为下一位相加的进位，
     * 同时记录余数，作为本位的结果，一直处理，直到所有的结点都处理完。
     * </pre>
     *
     * @param l1 第一个数
     * @param l2 第二个数
     * @return 结果
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode root = new ListNode(0); // 头结点
        ListNode r = root;
        root.next = l1;

        int carry = 0; // 初始进位
        int sum;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            p1.val = sum % 10; // 本位的结果
            carry = sum / 10; // 本次进位

            r.next = p1;
            r = p1; // 指向最后一个相加的结点
            p1 = p1.next;
            p2 = p2.next;

        }

        if (p1 == null) {
            r.next = p2;
        } else {
            r.next = p1;
        }

        // 最后一次相加还有进位
        if (carry == 1) {
            // 开始时r.next是第一个要相加的结点
            while (r.next != null) {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }

            // 都加完了还有进位，就要创建一个新的结点
            if (carry == 1) {
                r.next = new ListNode(1);
            }
        }

        return root.next;
    }

    public static void linkListTest(Context context, int[] arrInt, double[] arrDou, int keyFind, int keyDelete) {
        LinkListDatasTest linkListDatasTest = new LinkListDatasTest(context, arrInt, arrDou).invoke();
        if (linkListDatasTest.is()) return;
        int length = linkListDatasTest.getLength();
        LinkList linkList = new LinkList();
        for (int i = 0; i < length; i++) {
            linkList.insertFirst(arrInt[i], arrDou[i]);
        }
        linkList.displayLinkList();
        Link linkFind = linkList.find(keyFind);
        if (linkFind != null) {
            LogUtils.e("Found link with key " + linkFind.iData);
        } else {
            LogUtils.e("Can't find link " + linkFind.iData);
        }
        Link linkDelete = linkList.delete(keyDelete);
        if (linkDelete != null) {
            LogUtils.e("Deleted link with key " + linkDelete.iData);
        } else {
            LogUtils.e("Can't delete link " + linkDelete.iData);
        }
        linkList.displayLinkList();
        while (!linkList.isEmpty()) {
            Link link = linkList.deleteFirst();
            link.displayLink();
        }
        linkList.displayLinkList();
    }

    public static void doubleEndLinkListTest(Context context, int[] arrInt, double[] arrDou) {
        LinkListDatasTest linkListDatasTest = new LinkListDatasTest(context, arrInt, arrDou).invoke();
        if (linkListDatasTest.is()) return;
        int length = linkListDatasTest.getLength();
        FirstLastLinkList firstLastLinkList1 = new FirstLastLinkList();
        for (int i=0;i<length/2;i++){
            firstLastLinkList1.insertFirst(arrInt[i],arrDou[i]);
        }
        for (int i=length/2;i<length;i++){
            firstLastLinkList1.insertLast(arrInt[i],arrDou[i]);
        }
        firstLastLinkList1.displayFirstLastLinkList();
        firstLastLinkList1.deleteFirst();
        firstLastLinkList1.displayFirstLastLinkList();
        FirstLastLinkList firstLastLinkList2 = new FirstLastLinkList();
        firstLastLinkList2.insertLast(arrInt[0],arrDou[0]);
        firstLastLinkList2.displayFirstLastLinkList();
    }
}
