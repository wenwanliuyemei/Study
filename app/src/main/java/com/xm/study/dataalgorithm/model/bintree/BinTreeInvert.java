package com.xm.study.dataalgorithm.model.bintree;

/**
 * @author: xm on 2017/9/22.
 * @describe:
 */

public class BinTreeInvert {

    public static BinTreeNode invertTree(BinTreeNode root) {

        if (root != null) {
            invertTreeNode(root);
        }
        return root;
    }

    public static void invertTreeNode(BinTreeNode root) {

        if (root != null) {
            BinTreeNode tmp = root.leftChild;
            root.leftChild = root.rightChild;
            root.rightChild = tmp;

            invertTree(root.leftChild);
            invertTree(root.rightChild);
        }
    }
}
