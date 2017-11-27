package com.xm.study.dataalgorithm.model.bintree;

import com.xm.utils.LogUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xm on 2017/11/9.
 * @describe:
 */

public class BinTreeUtils {

    public static BinTreeNode getBinTreeNode(int[] arr) {
        List<BinTreeNode> binTreeNodeList = BinTreeUtils.createBinTree(arr);
        return binTreeNodeList.get(0);
    }

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


    /**
     * <pre>
     * 原题
     * Given a binary tree, return the level order traversal of its nodes’ values.
     * (ie, from left to right, level by level).
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     *
     *    3
     *   / \
     *  9  20
     *    /  \
     *   15   7
     *
     * return its level order traversal as:
     *
     * [
     *  [3],
     *  [9,20],
     *  [15,7]
     * ]
     * 题目大意
     * 给定一个二叉树，输出它的每一层的结点。
     *
     * 解题思路
     * 使用两队列，一个保存当前处理的层，一个保存下一次要处理的层。只到每一层都处理完。
     * </pre>
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(BinTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<BinTreeNode> cur = new LinkedList<>();
        Deque<BinTreeNode> sub = new LinkedList<>();
        Deque<BinTreeNode> exc;
        BinTreeNode node;
        cur.addLast(root);
        while (!cur.isEmpty()) {
            List<Integer> layout = new LinkedList<>();
            while (!cur.isEmpty()) {
                node = cur.removeFirst();
                layout.add(node.data);

                if (node.leftChild != null) {
                    sub.addLast(node.leftChild);
                }

                if (node.rightChild != null) {
                    sub.addLast(node.rightChild);
                }
            }
            exc = cur;
            cur = sub;
            sub = exc;
            result.add(layout);
        }
        return result;
    }

    /**
     * <pre>
     * Given a binary tree, return the zigzag level order traversal of its nodes' values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its zigzag level order traversal as:
     * [
     *      [3],
     *      [20,9],
     *      [15,7]
     * ]
     *
     * 题目大意：
     * 给定一棵二叉树，从顶向下，进行Z字形分层遍历，即：如果本层是从左向右的，下层就是从右向左
     *
     * 解题思路：
     * 二叉树分层遍历进行改进，使用两个栈来进行
     * </pre>
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(BinTreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 遍历标志，0表示从左到右，1表示从右到左
        int flag = 0;
        BinTreeNode node;
        // 记录每一层的元素
        List<Integer> lay = new LinkedList<>();
        // 双向队列，当作栈来使用，记录当前层待处理结点
        Deque<BinTreeNode> stack = new LinkedList<>();
        // 记录下一层待处理结点
        Deque<BinTreeNode> nextStack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            // 删除栈顶元素
            node = stack.removeLast();
            // 结果入队
            lay.add(node.data);
            // 如果当前是从左到右遍历，按左子树右子树的顺序添加
            if (flag == 0) {
                if (node.leftChild != null) {
                    nextStack.addLast(node.leftChild);
                }

                if (node.rightChild != null) {
                    nextStack.addLast(node.rightChild);
                }
            }
            // 如果当前是从右到左遍历，按右子树左子树的顺序添加
            else {
                if (node.rightChild != null) {
                    nextStack.addLast(node.rightChild);
                }

                if (node.leftChild != null) {
                    nextStack.addLast(node.leftChild);
                }
            }
            // 当前层已经处理完了
            if (stack.isEmpty()) {
                Deque<BinTreeNode> temp = nextStack;
                nextStack = stack;
                stack = temp;

                // 标记下一层处理的方向
                flag = 1 - flag;
                // 保存本层结果
                result.add(lay);
                // 创建新的链表处理下一层的结果
                lay = new LinkedList<>();
            }
        }
        return result;
    }

    /**
     * <pre>
     * 原题
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     *
     * 题目大意
     * 给定一棵两叉树，求它的最大深度。
     *
     * 解题思路
     * 递归求解，递归公式
     * f(n) = 0; n=null,
     * f(n) = 1+ max(f(n左)， f(n右))
     * </pre>
     *
     * @param root
     * @return
     */
    public static int maxDepth(BinTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.leftChild == null && root.rightChild == null) {
            return 1;
        } else {
            int left = maxDepth(root.leftChild);
            int right = maxDepth(root.rightChild);
            return 1 + (left > right ? left : right);
        }
    }


    /**
     * @param one
     * @param two
     * @param which 1给定前序、中序；2给定中序、后序
     * @return
     */
    public static BinTreeNode buildTree(int[] one, int[] two, int which) {
        // 参数校验
        if (one == null || two == null || one.length == 0
                || one.length != two.length) {
            return null;
        }
        switch (which) {
            case 1:
                return solvePreIn(one, 0, one.length - 1, two, 0, two.length - 1);
            case 2:
                // 构建二叉树
                return solveInPosst(one, 0, one.length - 1, two, 0, two.length - 1);
            default:
                return null;
        }
    }

    /**
     * 构建二叉树，数据输入的正确性由输入数据自己保证
     * <pre>
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * 题目大意：
     * 给定一个前序和中序遍历序列，构建一个二叉树
     * 注意：
     *   - 二叉树中元素重复元素
     *
     * 解题思路：
     * 前序遍历第一个元素是根结点（k），在中序遍历序列中找值为k的下标idx
     * idx将中序遍历序列分成左右子树，对前序遍历序列也一样，可进行递归操作
     * </pre>
     *
     * @param preorder 先序遍历的结果
     * @param x        先序遍历的开始位置
     * @param y        先序遍历的结束位置
     * @param inorder  中序遍历的结果
     * @param i        中序遍历的开始位置
     * @param j        中序遍历的结束位置
     * @return 二叉树的根结点
     */
    public static BinTreeNode solvePreIn(int[] preorder, int x, int y, int[] inorder, int i, int j) {
        if (x >= 0 && x <= y && i >= 0 && i <= j) {
            // 只有一个元素
            if (x == y) {
                return new BinTreeNode(preorder[x]);
            } else if (x < y) {
                // 记录根结点的索引
                int idx = i;
                while (idx <= j && inorder[idx] != preorder[x]) {
                    idx++;
                }
                // 创建根结点
                BinTreeNode root = new BinTreeNode(inorder[idx]);
                // 左子树的结点个数
                int leftLength = idx - i;
                //
                if (leftLength > 0) {
                    // x + 1, x + leftLength：左子树起始和结束位置
                    root.leftChild = solvePreIn(preorder, x + 1, x + leftLength, inorder, i, idx - 1);
                }
                // 右子树的结点个数
                int rightLength = j - idx;
                if (rightLength > 0) {
                    // x + leftLength + 1, y：右子树起始和结束位置
                    root.rightChild = solvePreIn(preorder, x + leftLength + 1, y, inorder, idx + 1, j);
                }
                return root;
            }
        }
        return null;
    }

    /**
     * 构建二叉树
     * <pre>
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * 题目大意：
     * 给定一个中序遍历和后序遍历序列，构造一棵二叉树
     * 注意：
     * 树中没有重复元素
     *
     * 解题思路：
     * 后序遍历的最后一个元素就是树的根结点(值为r)，
     * 在中序遍历的序列中找值为r的位置idx，idx将中序遍历序列分为左右两个子树，
     * 对应可以将后序遍历的序列分在两个子树，递归对其进行求解
     * </pre>
     *
     * @param inorder   中序遍历的结果
     * @param x         中序遍历的开始位置
     * @param y         中序遍历的结束位置
     * @param postorder 后序遍历的结果
     * @param i         后序遍历的开始位置
     * @param j         后序遍历的结束位置
     * @return 二叉树
     */
    public static BinTreeNode solveInPosst(int[] inorder, int x, int y, int[] postorder, int i, int j) {
        if (x >= 0 && x <= y && i >= 0 && i <= j) {
            // 只有一个元素，（此时也有i=j成）
            if (x == y) {
                return new BinTreeNode(postorder[j]);
            }
            // 多于一个元素，此时也有i<j
            else if (x < y) {
                // 创建根结点
                BinTreeNode root = new BinTreeNode(postorder[j]);
                // 找根结点在中序遍历的下标
                int idx = x;
                while (idx < y && inorder[idx] != postorder[j]) {
                    idx++;
                }
                // 左子树非空，构建左子树
                int leftLength = idx - x;
                if (leftLength > 0) {
                    // i, i + leftLength - 1，前序遍历的左子树的起始，结束位置
                    root.leftChild = solveInPosst(inorder, x, idx - 1, postorder, i, i + leftLength - 1);
                }
                // 右子树非空，构建右子树
                int rightLength = y - idx;
                if (rightLength > 0) {
                    // i + leftLength, j - 1，前序遍历的右子树的起始，结束位置
                    root.rightChild = solveInPosst(inorder, idx + 1, y, postorder, i + leftLength, j - 1);
                }
                return root;
            }
        }
        return null;
    }

    /**
     * <pre>
     * Given a binary tree, return the bottom-up level order traversal of its nodes’ values.
     * (ie, from left to right, level by level from leaf to root).
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its bottom-up level order traversal as:
     *
     * [
     *  [15,7],
     *  [9,20],
     *  [3]
     * ]
     *
     * 题目大意
     * 给定一棵二叉树自底向上进行层序遍历。
     *
     * 解题思路
     * 对树进行层序遍历，每层的结果放在结果链表的头部。
     * </pre>
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(BinTreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<BinTreeNode> cur = new LinkedList<>();
        Deque<BinTreeNode> nxt = new LinkedList<>();
        Deque<BinTreeNode> exc = new LinkedList<>();
        BinTreeNode tmp;
        cur.add(root);
        while (!cur.isEmpty()) {
            List<Integer> layout = new ArrayList<>();
            while (!cur.isEmpty()) {
                tmp = cur.remove();
                if (tmp.leftChild != null) {
                    nxt.add(tmp.leftChild);
                }
                if (tmp.rightChild != null) {
                    nxt.add(tmp.rightChild);
                }
                layout.add(tmp.data);
            }
            exc = cur;
            cur = nxt;
            nxt = exc;
            list.add(0, layout);
        }
        return list;
    }

    /**
     * <pre>
     * Given an array where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     *
     * 题目大意：
     * 给定一个升序排序数组，将它转换成一个高度平衡二叉树
     *
     * 解题思路：
     * 采用递归分治法
     * </pre>
     *
     * @param nums
     * @return
     */
    public static BinTreeNode sortedArrayToBST(int[] nums) {
        // 参数检验
        if (nums == null || nums.length < 1) {
            return null;
        }
        // 递归分治法求解
        return solve(nums, 0, nums.length - 1);
    }

    /**
     * 递归分治求解方法
     *
     * @param nums  升序排序数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 根结点
     */
    public static BinTreeNode solve(int[] nums, int start, int end) {
        // 还有未处理的数据
        if (start <= end) {
            // 找蹭位置
            int mid = start + ((end - start) >> 1);//右移一位
            LogUtils.e("start=" + start + ",end=" + end + ",mid=" + mid);
            // 构造根结点
            BinTreeNode root = new BinTreeNode(nums[mid]);
            // 求左子树
            root.leftChild = solve(nums, start, mid - 1);
            // 求右子树
            root.rightChild = solve(nums, mid + 1, end);
            // 返回结果
            return root;
        }
        return null;
    }

    /**
     * <pre>
     * Given a singly linked list where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     *
     * 题目大意：
     * 给定一个升序的单链表，将它转换成一颗高度平衡的二叉树
     *
     * 解题思路：
     * 解法一：将单链表中的值存入一个数组中，通过数组来构建二叉树，算法时间复杂度是：O(n)，空间复杂度是：O(n)
     * 解法二：采用递归的方式，
     *      （一）找中间结点，构建根结点，
     *      （二）中间结点左半部分构建左子树，
     *      （三）中间结点的右部分构建右子树
     * 题采用第二种解法
     * </pre>
     *
     * @param head
     * @return
     */
    public static BinTreeNode sortedListToBST(ListBinTreeNode head) {
        // 如果链表为空就直接返回null
        if (head == null) {
            return null;
        }
        // 链表只有一个结点
        if (head.next == null) {
            return new BinTreeNode(head.val);
        }
        // 快速移动结点，每次移动两个位置
        ListBinTreeNode fast = head.next.next;
        // 记录中间结点
        ListBinTreeNode mid = head;
        // 找中间结点
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        // 以中间结点的下一个结点作为根结点
        BinTreeNode root = new BinTreeNode(mid.next.val);
        // 构建右子树
        root.rightChild = sortedListToBST(mid.next.next);//2
        // 记录链表要断开的点
        ListBinTreeNode midNext = mid.next;//mindNext=1、2，
        // 断开单链表（会破坏原来单链表的结构）
        //如果原来head是-1、0、1、2，mid=0、1、2，经过mid.next = null后，head会变化，
        // 则现在head变为-1、0，mid=0，mindNext=1、2
        mid.next = null;
        // 构建左子树
        root.leftChild = sortedListToBST(head);
        // 重新将链表接好
        mid.next = midNext;//又重新补充完整
        // 返回结果
        return root;
    }

    public static ListBinTreeNode getListBinTreeNode(int[] arr) {
//        if(arr==null||arr.length==0){
//            return null;
//        }
//
//        ListBinTreeNode listBinTreeNode0 = new ListBinTreeNode(0);
//        if(arr.length>=1){
//
//            for (int i=1;i<arr.length;i++){
//                ListBinTreeNode listBinTreeNode1 = new ListBinTreeNode(arr[i]);
//                n1.next = n2;
//            }
//        }
        ListBinTreeNode n1 = new ListBinTreeNode(-1);
        ListBinTreeNode n2 = new ListBinTreeNode(0);
        ListBinTreeNode n3 = new ListBinTreeNode(1);
        ListBinTreeNode n4 = new ListBinTreeNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static void print2(BinTreeNode root) {
        if (root != null) {
            List<BinTreeNode> list = new LinkedList<>();
            list.add(root);
            BinTreeNode node;
            int curr = 1;
            int next = 0;
            while (!list.isEmpty()) {
                node = list.remove(0);
                curr--;
                System.out.print(node.data + ", ");

                if (node.leftChild != null) {
                    list.add(node.leftChild);
                    next++;
                }

                if (node.rightChild != null) {
                    list.add(node.rightChild);
                    next++;
                }

                if (curr == 0) {
                    System.out.println();
                    curr = next;
                    next = 0;
                }
            }
        }
    }

    /**
     * <pre>
     * 原题
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as a binary tree
     * in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * 题目大意
     * 给定一棵平衡二叉树，判断它是否是高度平衡的。一棵高度平衡的二叉树是左右子树的高度相差不超过1，
     * 对其左右子树也是如此。
     *
     * 解题思路
     * 递归分治法求解。
     * </pre>
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(BinTreeNode root) {

        if (root == null) {
            return true;
        }

        int left = maxDepth(root.leftChild);
        int right = maxDepth(root.rightChild);
        if (left - right > 1 || left - right < -1) {
            return false;
        } else {
            return isBalanced(root.leftChild) && isBalanced(root.rightChild);
        }
    }

}
