package com.xm.study.dataalgorithm.model.bintree;

import com.xm.utils.LogUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xm on 2017/11/9.
 * @describe:
 */

public class BinTreeUtils {

    /**
     * 1、先add到list。
     * 2、前lastParentIndex-1个父节点添加左右孩子。
     * 3、lastParentIndex父节点可能没有右孩子，但肯定有左孩子。
     *
     * @param array
     * @return
     */
    public static List<BinTreeNode> createBinTree(int[] array) {
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

    /**
     * 二叉树倒置
     *
     * @param root
     * @return
     */
    public static BinTreeNode invertTree(BinTreeNode root) {

        if (root != null) {
            invertTreeNode(root);
        }
        return root;
    }

    /**
     * 二叉树倒置
     *
     * @param root
     */
    public static void invertTreeNode(BinTreeNode root) {

        if (root != null) {
            BinTreeNode tmp = root.leftChild;
            root.leftChild = root.rightChild;
            root.rightChild = tmp;

            invertTree(root.leftChild);
            invertTree(root.rightChild);
        }
    }

    /**
     * @author: xm on 2017/9/26.
     * @describe: 题目大意
     * Given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     * <p>
     * For example:
     * Given the following binary tree,
     * 1            <---
     * /   \
     * 2     3         <---
     * \     \
     * 5     4       <---
     * You should return [1, 3, 4].
     * <p>
     * 题目大意：
     * 给定一个二叉树，想象自己站在树的右边，返回从上到下你能看到的节点的值。
     * <p>
     * 解题思路：
     * 二叉树的层次遍历，每层按照从左向右的顺序依次访问节点，（每一层取最右边的结点）
     */
    public static List<Integer> rightSideView(BinTreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            Deque<BinTreeNode> deque = new LinkedList<>();
            // 当前层的结点数
            int current = 1;
            // 下一层的结点数
            int next = 0;
            BinTreeNode node;
            deque.addLast(root);
            while (deque.size() > 0) {
                // 取第一个结点
                node = deque.removeFirst();
                current--;
                // 添加非空的左结点
                if (node.leftChild != null) {
                    next++;
                    deque.addLast(node.leftChild);
                }
                // 添加非空的右结点
                if (node.rightChild != null) {
                    next++;
                    deque.addLast(node.rightChild);
                }
                // 如果当前层已经处理完了
                if (current == 0) {
                    // 保存此层的最右一个结点值
                    result.add(node.data);
                    // 设置下一层的元素个数
                    current = next;
                    next = 0;
                }
            }
        }
        return result;
    }

    /**
     * 同rightSideView
     *
     * @param root
     * @return
     */
    public static List<Integer> leftSideView(BinTreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            Deque<BinTreeNode> deque = new LinkedList<>();
            // 当前层的结点数
            BinTreeNode node;
            deque.addLast(root);
            while (deque.size() > 0) {
                node = deque.getFirst();
                result.add(node.data);
                deque.clear();
                // 添加非空的左结点
                if (node.leftChild != null) {
                    deque.addLast(node.leftChild);
                }
                // 添加非空的右结点
                if (node.rightChild != null) {
                    deque.addLast(node.rightChild);
                }
            }
        }
        return result;
    }

    /**
     * @author: xm on 2017/11/9.
     * @describe: 题目大意
     * <pre>
     * 原题
     * Given two binary trees, write a function to check if they are equal or not.
     * Two binary trees are considered equal if they are structurally identical and
     * the nodes have the same value.
     *
     * 题目大意
     * 给定两个二叉树，判断这两棵树是否相等。
     * 仅当两棵树的结构相同，结点值都相等时都会相等。
     *
     * 解题思路
     * 使用递归进行求解，先判断当前结点值是否相等，如果相等就再比较其左右子树，
     * 只有当所有的结点都相等才相等。
     * </pre>
     */
    public static boolean isSameTree(BinTreeNode p, BinTreeNode q) {
        return isSameTree(p, q, 1);
    }

    public static boolean isSameTree(BinTreeNode left, BinTreeNode right, int which) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return true;
        }
        boolean result = false;
        switch (which) {
            case 1:
                result = left.data == right.data && isSameTree(left.leftChild, right.leftChild, which)
                        && isSameTree(left.rightChild, right.rightChild, which);
                break;
            case 2:
                result = left.data == right.data && isSameTree(left.leftChild, right.rightChild, which)
                        && isSameTree(left.rightChild, right.leftChild, which);
                break;
        }
        return result;
    }

    /**
     * <pre>
     * 原题
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * For example, this binary tree is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * 　　But the following is not:
     *
     *   1
     *  / \
     * 2   2
     * \   \
     * 3    3
     *
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     * 题目大意
     * 给定一棵树，判断它是否是对称的。即树的左子树是否是其右子树的镜像。
     *
     * 解题思路
     * 使用递归进行求解，先判断左右子结点是否相等，不等就返回false，相等就将左子结点的左子树与
     * 右子结果的右子结点进行比较操作，同时将左子结点的左子树与右子结点的左子树进行比较，只有两
     * 个同时为真是才返回true，否则返回false。
     * </pre>
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(BinTreeNode root) {

        if (root == null) {
            return true;
        } else {
            return isSameTree(root.leftChild, root.rightChild, 2);
        }
    }
}
