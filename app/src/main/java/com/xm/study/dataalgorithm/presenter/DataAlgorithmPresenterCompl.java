package com.xm.study.dataalgorithm.presenter;

import android.content.Context;
import android.util.Log;

import com.xm.study.dataalgorithm.model.bintree.BinTreeInvert;
import com.xm.study.dataalgorithm.model.bintree.BinTreeNode;
import com.xm.study.dataalgorithm.model.bintree.BinTreeTraverse;
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
        Log.e(TAG, "insertSort--arr" + Arrays.toString(arr));
        iDataAlgorithmView.insertSortDone();
    }

    @Override
    public void bubbleSort1(int[] arr) {
        arr = BubbleSort.getInstance().bubbleSort1(arr);
        Log.e(TAG, "bubbleSort1--arr" + Arrays.toString(arr));
        iDataAlgorithmView.bubbleSort1Done();
    }

    @Override
    public void bubbleSort2(int[] arr) {
        arr = BubbleSort.getInstance().bubbleSort2(arr);
        Log.e(TAG, "bubbleSort2--arr" + Arrays.toString(arr));
        iDataAlgorithmView.bubbleSort2Done();
    }

    @Override
    public void quickSort(int[] arr) {
        arr = QuickSort.getQuickSort().quickSort(arr);
        Log.e(TAG, "quickSort--arr" + Arrays.toString(arr));
        iDataAlgorithmView.quickSortDone();
    }

    @Override
    public void selectionSort(int[] arr) {
        arr = SelectionSort.getSelectionSort().selectionSort(arr);
        Log.e(TAG, "selectionSort--arr" + Arrays.toString(arr));
        iDataAlgorithmView.selectionSortDone();
    }

    @Override
    public void shellSort(int[] arr) {
        arr = ShellSort.getShellSort().shellSort(arr);
        Log.e(TAG, "shellSort--arr" + Arrays.toString(arr));
        iDataAlgorithmView.shellSortDone();
    }

    @Override
    public void sequentialSort(int key, int[] arr) {
        int result = SequentialSort.getInstance().sequentialSort(key, arr);
        Log.e(TAG, "sequentialSort--arr=" + Arrays.toString(arr));
        Log.e(TAG, "sequentialSort--result=" + result);
        iDataAlgorithmView.sequentialSortDone();
    }

    @Override
    public void binTreeSort(int[] arr) {
        BinTreeTraverse binTree = new BinTreeTraverse();
        List<BinTreeNode> nodeList = binTree.createBinTree(arr);
        // nodeList中第0个索引处的值即为根节点
        BinTreeNode root = nodeList.get(0);
        LogUtils.e("先序遍历：");
        BinTreeTraverse.preOrderTraverse(root);
        LogUtils.e("中序遍历：");
        BinTreeTraverse.inOrderTraverse(root);
        LogUtils.e("后序遍历：");
        BinTreeTraverse.postOrderTraverse(root);
        BinTreeNode binTreeNode = BinTreeInvert.invertTree(root);
        LogUtils.e("invert：" + binTreeNode.toString());
        iDataAlgorithmView.binTreeSortDone();
    }

    @Override
    public void countOneInBinary(int num) {
        CountOneInBinary.hammingWeight(num);//12
        iDataAlgorithmView.countOneInBinaryDone();
    }

    @Override
    public void maxSum(int[] arrInt) {
        int[] arrIntTemp=arrInt;
//        LogUtils.e("maxSum=" + MaxSum.maxSum(arrInt));
        Map<Integer,List<Object>> map=MaxSum.maxSum2(arrIntTemp);
        LogUtils.e("map="+map);
        iDataAlgorithmView.maxSumDone();
    }
}
