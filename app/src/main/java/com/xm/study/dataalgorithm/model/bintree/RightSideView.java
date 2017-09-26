package com.xm.study.dataalgorithm.model.bintree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

public class RightSideView {

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

    public static List<Integer> leftSideView(BinTreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            Deque<BinTreeNode> deque = new LinkedList<>();
            // 当前层的结点数
            BinTreeNode node;
            deque.addLast(root);
            while (deque.size() > 0) {
                node=deque.getFirst();
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

}
