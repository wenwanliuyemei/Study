package com.xm.study.dataalgorithm.presenter;

import com.xm.study.dataalgorithm.model.bintree.BinTreeNode;

/**
 * Created by zhangxiumei on 2017/3/13.
 */

public interface IDataAlgorithmPresenter {

    void insertSort(int[] arr);

    void bubbleSort1(int[] arr);

    void bubbleSort2(int[] arr);

    void quickSort(int[] arr);

    void selectionSort(int[] arr);

    void shellSort(int[] arr);

    void sequentialSort(int key, int[] arr);

    void binTreeSort(int[] arr);

    void isSameTree(int[] arrPq, int[] arrQ);

    void isSymmetric(int[] arr);

    void levelOrder(int[] arr);

    void levelOrderBottom(int[] arr);

    void zigzagLevelOrder(int[] arr);

    void maxDepth(int arr[]);

    void minDepth(int arr[]);

    void isBalanced(int arr[]);

    void buildTreePreIn(int[] preorder, int[] inorder);

    void buildTreeInPosst(int[] inorder, int[] postorder);

    void buildTreeNull(int[] inorder, int[] postorder);

    void sortedArrayToBST(int[] arr);

    void sortedListToBST(int[] arr);

    void countOneInBinary(int num);

    void maxSum(int[] arrInt);

    void twoSum(int[] arrInt, int target);

    void addTwoNumbers();

    void lengthOfLongestSubstring(String str);

    void lengthOfLongestSubstring2(String str);

    void findMedianSortedArrays(int[] nums1, int[] nums2);

    //stack
    void doReverser(String in);

    void bracketChecker(String in);

    void doTrans(String in);

    void doParse(String in);

    void linkStackTest(int[] arrInt, double[] arrDou);

    //queue
    void queueTest(long[] arr1, long[] arr2);

    void queuePriorityTest(long[] arr);

    //LinkList
    void linkListTest(int[] arrInt, double[] arrDou, int keyFind, int keyDelete);

    void doubleEndLinkListTest(int[] arrInt, double[] arrDou);
}
