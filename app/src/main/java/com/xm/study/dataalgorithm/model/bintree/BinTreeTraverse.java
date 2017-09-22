package com.xm.study.dataalgorithm.model.bintree;

import com.xm.utils.LogUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: xm on 2017/9/21.
 * @describe:
 */

public class BinTreeTraverse {

    /**
     * 1、先add到list。
     * 2、前lastParentIndex-1个父节点添加左右孩子。
     * 3、lastParentIndex父节点可能没有右孩子，但肯定有左孩子。
     *
     * @param array
     * @return
     */
    public List<BinTreeNode> createBinTree(int[] array) {
        List<BinTreeNode> nodeList = new LinkedList<BinTreeNode>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new BinTreeNode(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
        LogUtils.e("nodeList=" + nodeList.toString());
        return nodeList;
    }

    /**
     * 先序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void preOrderTraverse(BinTreeNode node) {
        if (node == null)
            return;
        LogUtils.e(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void inOrderTraverse(BinTreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        LogUtils.e(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void postOrderTraverse(BinTreeNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        LogUtils.e(node.data + " ");
    }

    private List<BinTreeNode> a(int[] arr) {
        List<BinTreeNode> binTreeNodeList = new LinkedList<>();
        for (int position = 0; position < arr.length; position++) {
            binTreeNodeList.add(new BinTreeNode(arr[position]));
        }
        for (int parentPositon = 0; parentPositon < binTreeNodeList.size() / 2 - 1; parentPositon++) {
            binTreeNodeList.get(parentPositon).leftChild = binTreeNodeList.get(parentPositon * 2 + 1);
            binTreeNodeList.get(parentPositon).rightChild = binTreeNodeList.get(parentPositon * 2 + 2);
        }

        int lastParentPosition = binTreeNodeList.size() / 2 - 1;
        binTreeNodeList.get(lastParentPosition).leftChild = binTreeNodeList.get(lastParentPosition * 2 + 1);
        if (binTreeNodeList.size() % 2 == 1) {
            binTreeNodeList.get(lastParentPosition).rightChild = binTreeNodeList.get(lastParentPosition * 2 + 2);
        }
        return binTreeNodeList;
    }
}
