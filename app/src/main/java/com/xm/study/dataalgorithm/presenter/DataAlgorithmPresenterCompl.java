package com.xm.study.dataalgorithm.presenter;

import android.content.Context;

import com.xm.study.dataalgorithm.model.bintree.BinTreeNode;
import com.xm.study.dataalgorithm.model.bintree.BinTreeUtils;
import com.xm.study.dataalgorithm.model.count.CountOneInBinary;
import com.xm.study.dataalgorithm.model.count.MaxSum;
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
