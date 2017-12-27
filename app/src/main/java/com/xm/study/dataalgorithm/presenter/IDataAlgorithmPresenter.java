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

    void twoSum(int[] arrInt,int target);

    void addTwoNumbers();

}
