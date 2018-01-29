package com.xm.study.dataalgorithm.presenter;

import android.content.Context;

import com.xm.study.dataalgorithm.model.queue.QueueUtils;
import com.xm.study.dataalgorithm.model.stack.StackUtils;
import com.xm.study.dataalgorithm.model.string.StringUtils;
import com.xm.study.dataalgorithm.model.list.ListNode;
import com.xm.study.dataalgorithm.model.bintree.BinTreeNode;
import com.xm.study.dataalgorithm.model.bintree.BinTreeUtils;
import com.xm.study.dataalgorithm.model.count.CountOneInBinary;
import com.xm.study.dataalgorithm.model.count.MaxSum;
import com.xm.study.dataalgorithm.model.array.ArraysUtils;
import com.xm.study.dataalgorithm.model.list.LinkedListUtils;
import com.xm.study.dataalgorithm.model.sort.BubbleSort;
import com.xm.study.dataalgorithm.model.sort.InsertSort;
import com.xm.study.dataalgorithm.model.sort.QuickSort;
import com.xm.study.dataalgorithm.model.sort.SelectionSort;
import com.xm.study.dataalgorithm.model.sort.SequentialSort;
import com.xm.study.dataalgorithm.model.sort.ShellSort;
import com.xm.study.dataalgorithm.view.IDataAlgorithmView;
import com.xm.utils.LogUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiumei on 2017/3/13.
 */
public class DataAlgorithmPresenterCompl implements IDataAlgorithmPresenter {

    private final String TAG = this.getClass().getSimpleName();

    private Context context;
    private IDataAlgorithmView iDataAlgorithmView;

    public DataAlgorithmPresenterCompl(Context context, IDataAlgorithmView iDataAlgorithmView) {
        this.context = context;
        this.iDataAlgorithmView = iDataAlgorithmView;
    }

    @Override
    public void insertSort(int[] arr) {
        arr = InsertSort.getInstance().insertSort(arr);
        LogUtils.e(TAG, "insertSort--arr" + Arrays.toString(arr));
        iDataAlgorithmView.insertSortDone();
    }

    @Override
    public void bubbleSort1(int[] arr) {
        arr = BubbleSort.getInstance().bubbleSort1(arr);
        LogUtils.e(TAG, "bubbleSort1--arr" + Arrays.toString(arr));
        iDataAlgorithmView.bubbleSort1Done();
    }

    @Override
    public void bubbleSort2(int[] arr) {
        arr = BubbleSort.getInstance().bubbleSort2(arr);
        LogUtils.e(TAG, "bubbleSort2--arr" + Arrays.toString(arr));
        iDataAlgorithmView.bubbleSort2Done();
    }

    @Override
    public void quickSort(int[] arr) {
        arr = QuickSort.getQuickSort().quickSort(arr);
        LogUtils.e(TAG, "quickSort--arr" + Arrays.toString(arr));
        iDataAlgorithmView.quickSortDone();
    }

    @Override
    public void selectionSort(int[] arr) {
        arr = SelectionSort.getSelectionSort().selectionSort(arr);
        LogUtils.e(TAG, "selectionSort--arr" + Arrays.toString(arr));
        iDataAlgorithmView.selectionSortDone();
    }

    @Override
    public void shellSort(int[] arr) {
        arr = ShellSort.getShellSort().shellSort(arr);
        LogUtils.e(TAG, "shellSort--arr" + Arrays.toString(arr));
        iDataAlgorithmView.shellSortDone();
    }

    @Override
    public void sequentialSort(int key, int[] arr) {
        int result = SequentialSort.getInstance().sequentialSort(key, arr);
        LogUtils.e(TAG, "sequentialSort--arr=" + Arrays.toString(arr));
        LogUtils.e(TAG, "sequentialSort--result=" + result);
        iDataAlgorithmView.sequentialSortDone();
    }

    @Override
    public void binTreeSort(int[] arr) {
//        BinTreeUtils binTree = new BinTreeUtils();
        BinTreeNode root = BinTreeUtils.getBinTreeNode(arr);
        LogUtils.e("先序遍历：");
        BinTreeUtils.preOrderTraverse(root);
        LogUtils.e("中序遍历：");
        BinTreeUtils.inOrderTraverse(root);
        LogUtils.e("后序遍历：");
        BinTreeUtils.postOrderTraverse(root);
        BinTreeNode binTreeNode = BinTreeUtils.invertTree(root);
        LogUtils.e("invert：" + binTreeNode.toString());
        List<Integer> rightSideViewList = BinTreeUtils.rightSideView(root);
        LogUtils.e("rightSideViewList：" + rightSideViewList.toString());
        List<Integer> leftSideViewList = BinTreeUtils.leftSideView(root);
        LogUtils.e("leftSideViewList：" + leftSideViewList.toString());
        iDataAlgorithmView.binTreeSortDone();
    }

    @Override
    public void isSameTree(int[] arrP, int[] arrQ) {
        BinTreeNode p = BinTreeUtils.getBinTreeNode(arrP);
        BinTreeNode q = BinTreeUtils.getBinTreeNode(arrQ);
        iDataAlgorithmView.isSameTreeDone(BinTreeUtils.isSameTree(p, q));
    }

    @Override
    public void isSymmetric(int[] arr) {
        BinTreeNode binTreeNodeRoot = BinTreeUtils.getBinTreeNode(arr);
        iDataAlgorithmView.isSymmetricDone(BinTreeUtils.isSymmetric(binTreeNodeRoot));
    }

    @Override
    public void levelOrder(int[] arr) {
        BinTreeNode binTreeNodeRoot = BinTreeUtils.getBinTreeNode(arr);
        iDataAlgorithmView.levelOrderDone(iteratorList(BinTreeUtils.levelOrder(binTreeNodeRoot)));
    }

    @Override
    public void levelOrderBottom(int[] arr) {
        BinTreeNode binTreeNodeRoot = BinTreeUtils.getBinTreeNode(arr);
        iDataAlgorithmView.levelOrderBottomDone(iteratorList(BinTreeUtils.levelOrderBottom(binTreeNodeRoot)));
    }

    @Override
    public void zigzagLevelOrder(int[] arr) {
        BinTreeNode binTreeNodeRoot = BinTreeUtils.getBinTreeNode(arr);
        iDataAlgorithmView.zigzagLevelOrderDone(iteratorList(BinTreeUtils.zigzagLevelOrder(binTreeNodeRoot)));
    }

    @Override
    public void maxDepth(int[] arr) {
        BinTreeNode binTreeNodeRoot = BinTreeUtils.getBinTreeNode(arr);
        iDataAlgorithmView.maxDepthDone(BinTreeUtils.maxDepth(binTreeNodeRoot));
    }

    @Override
    public void minDepth(int[] arr) {
        BinTreeNode binTreeNodeRoot = BinTreeUtils.getBinTreeNode(arr);
        iDataAlgorithmView.minDepthDone(BinTreeUtils.getBinTreeUtils().minDepth(binTreeNodeRoot));
    }

    @Override
    public void isBalanced(int[] arr) {
        BinTreeNode binTreeNodeRoot = BinTreeUtils.getBinTreeNode(arr);
        iDataAlgorithmView.isBalancedDone(BinTreeUtils.isBalanced(binTreeNodeRoot));
    }

    @Override
    public void buildTreePreIn(int[] preorder, int[] inorder) {
        iDataAlgorithmView.buildTreePreInDone(BinTreeUtils.buildTree(preorder, inorder, 1));
    }

    @Override
    public void buildTreeInPosst(int[] inorder, int[] postorder) {
        iDataAlgorithmView.buildTreeInPosstDone(BinTreeUtils.buildTree(inorder, postorder, 2));
    }

    @Override
    public void buildTreeNull(int[] inorder, int[] postorder) {
        iDataAlgorithmView.buildTreeNullDone(BinTreeUtils.buildTree(inorder, postorder, 3));
    }

    @Override
    public void sortedArrayToBST(int[] arr) {
        BinTreeNode binTreeNode = BinTreeUtils.sortedArrayToBST(arr);
        iDataAlgorithmView.sortedArrayToBSTDone(binTreeNode);
        LogUtils.e("先序遍历：");
        BinTreeUtils.preOrderTraverse(binTreeNode);
        iDataAlgorithmView.binTreeSortDone();
    }

    @Override
    public void sortedListToBST(int[] arr) {
        BinTreeNode root = BinTreeUtils.sortedListToBST(BinTreeUtils.getListBinTreeNode(arr));
        BinTreeUtils.print2(root);
        iDataAlgorithmView.sortedListToBSTDone(root);
    }

    @Override
    public void countOneInBinary(int num) {
        CountOneInBinary.hammingWeight(num);//12
        iDataAlgorithmView.countOneInBinaryDone();
    }

    @Override
    public void maxSum(int[] arrInt) {
        int[] arrIntTemp = arrInt;
//        LogUtils.e("maxSum=" + MaxSum.maxSum(arrInt));
        Map<Integer, List<Object>> map = MaxSum.maxSum2(arrIntTemp);
        LogUtils.e("map=" + map);
        iDataAlgorithmView.maxSumDone();
    }

    @Override
    public void twoSum(int[] arrInt, int target) {
        int[] result = ArraysUtils.twoSum(arrInt, target);
        iDataAlgorithmView.twoSumDone(result);
    }

    @Override
    public void addTwoNumbers() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(4);
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        ListNode listNode = LinkedListUtils.addTwoNumbers(listNode1, listNode5);
        iDataAlgorithmView.addTwoNumbersDone(listNode.toString());
    }

    @Override
    public void lengthOfLongestSubstring(String str) {
        int result = StringUtils.lengthOfLongestSubstring(str);
        iDataAlgorithmView.lengthOfLongestSubstringDone(result);
    }

    @Override
    public void lengthOfLongestSubstring2(String str) {
        int result = StringUtils.lengthOfLongestSubstring2(str);
        iDataAlgorithmView.lengthOfLongestSubstring2Done(result);
    }

    @Override
    public void findMedianSortedArrays(int[] nums1, int[] nums2) {
        iDataAlgorithmView.findMedianSortedArraysDone(ArraysUtils.findMedianSortedArrays(nums1, nums2));
    }

    @Override
    public void doReverser(String in) {
        iDataAlgorithmView.doReverserDone(StackUtils.doReverser(in));
    }

    @Override
    public void bracketChecker(String in) {
        StackUtils.bracketChecker(in);
        iDataAlgorithmView.bracketCheckerDone();

    }

    @Override
    public void doTrans(String in) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(StackUtils.doTrans(in));
        iDataAlgorithmView.doTransDone(stringBuffer.toString());
        doParse(stringBuffer.toString());
    }

    @Override
    public void doParse(String in) {
        iDataAlgorithmView.doParseDone(StackUtils.doParse(in));
    }

    @Override
    public void linkStackTest(int[] arrInt, double[] arrDou) {
        StackUtils.linkStackTest(context, arrInt, arrDou);
        iDataAlgorithmView.linkStackTestDone();
    }

    @Override
    public void queueTest(long[] arr1, long[] arr2) {
        QueueUtils.queueTest(arr1, arr2);
        iDataAlgorithmView.queueTestDone();
    }

    @Override
    public void queuePriorityTest(long[] arr) {
        QueueUtils.queuePriorityTest(arr);
        iDataAlgorithmView.queuePriorityTestDone();
    }

    @Override
    public void linkListTest(int[] arrInt, double[] arrDou, int keyFind, int keyDelete) {
        LinkedListUtils.linkListTest(context, arrInt, arrDou, keyFind, keyDelete);
        iDataAlgorithmView.linkListTestDone();
    }

    @Override
    public void doubleEndLinkListTest(int[] arrInt, double[] arrDou) {
        LinkedListUtils.doubleEndLinkListTest(context, arrInt, arrDou);
        iDataAlgorithmView.doubleEndLinkListTestDone();
    }

    private String iteratorList(List<List<Integer>> lists) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                stringBuffer.append(j);
                stringBuffer.append(":");
                stringBuffer.append(lists.get(i).get(j));
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }
}
