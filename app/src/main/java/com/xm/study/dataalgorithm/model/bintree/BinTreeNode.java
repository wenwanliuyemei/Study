package com.xm.study.dataalgorithm.model.bintree;

/**
 * @author: xm on 2017/9/21.
 * @describe: 二叉树节点
 */

public class BinTreeNode {
    BinTreeNode leftChild;
    BinTreeNode rightChild;
    int data;

    BinTreeNode(int newData) {
        leftChild = null;
        rightChild = null;
        data = newData;
    }
}
