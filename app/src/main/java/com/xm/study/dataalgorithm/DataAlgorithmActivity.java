package com.xm.study.dataalgorithm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.dataalgorithm.model.bintree.BinTreeNode;
import com.xm.study.dataalgorithm.presenter.DataAlgorithmPresenterCompl;
import com.xm.study.dataalgorithm.presenter.IDataAlgorithmPresenter;
import com.xm.study.dataalgorithm.view.IDataAlgorithmView;
import com.xm.study.database.TextbookSettingDB;
import com.xm.study.database.TextbookSettingDB2;
import com.xm.utils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 数据算法
 */
public class DataAlgorithmActivity extends BaseActivity implements IDataAlgorithmView {

    private final String TAG = this.getClass().getSimpleName();
    @Bind(R.id.tv_data_algorithm_insert_sort_1)
    TextView tvDataAlgorithmInsertSort1;
    @Bind(R.id.tv_data_algorithm_bubble_sort_1)
    TextView tvDataAlgorithmBubbleSort1;
    @Bind(R.id.tv_data_algorithm_bubble_sort_2)
    TextView tvDataAlgorithmBubbleSort2;
    @Bind(R.id.tv_data_algorithm_quick_sort)
    TextView tvDataAlgorithmQuickSort;
    @Bind(R.id.tv_data_algorithm_selection_sort)
    TextView tvDataAlgorithmSelectionSort;
    @Bind(R.id.tv_data_algorithm_shell_sort)
    TextView tvDataAlgorithmShellSort;
    @Bind(R.id.tv_data_algorithm_sequential_sort)
    TextView tvDataAlgorithmSequentialSort;
    @Bind(R.id.tv_bin_tree_sort)
    TextView tvBinTreeSort;
    @Bind(R.id.tv_count_1_in_binary)
    TextView tvCount1InBinary;
    @Bind(R.id.tv_bin_tree_is_same)
    TextView tvBinTreeIsSame;
    @Bind(R.id.tv_bin_tree_is_symmetric)
    TextView tvBinTreeIsSymmetric;
    @Bind(R.id.tv_bin_tree_level_order)
    TextView tvBinTreeLevelOrder;
    @Bind(R.id.tv_bin_tree_level_order_z)
    TextView tvBinTreeLevelOrderZ;
    @Bind(R.id.tv_bin_tree_max_depth)
    TextView tvBinTreeMaxDepth;
    @Bind(R.id.tv_bin_tree_create)
    TextView tvBinTreeCreate;
    @Bind(R.id.tv_bin_tree_create_bst)
    TextView tvBinTreeCreateBst;

    private IDataAlgorithmPresenter iDataAlgorithmPresenter;

    TextbookSettingDB textbookSettingDB;
    TextbookSettingDB2 textbookSettingDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_algorithm);
        ButterKnife.bind(this);

        iDataAlgorithmPresenter = new DataAlgorithmPresenterCompl(this, this);

        textbookSettingDB= new TextbookSettingDB(this);
        textbookSettingDB2= new TextbookSettingDB2(this);
    }

    @Override
    public void insertSortDone() {
        Log.e(TAG, "insertSortDone");
    }

    @Override
    public void bubbleSort1Done() {
        Log.e(TAG, "bubbleSort1Done");
    }

    @Override
    public void bubbleSort2Done() {
        Log.e(TAG, "bubbleSort2Done");
    }

    @Override
    public void quickSortDone() {
        Log.e(TAG, "quickSortDone");
    }

    @Override
    public void selectionSortDone() {
        Log.e(TAG, "selectionSortDone");
    }

    @Override
    public void shellSortDone() {
        Log.e(TAG, "shellSortDone");
    }

    @Override
    public void sequentialSortDone() {
        Log.e(TAG, "sequentialSortDone");
    }

    @Override
    public void binTreeSortDone() {
        LogUtils.e(TAG, "binTreeSortDone");
    }

    @Override
    public void isSameTreeDone(boolean isSameTree) {
        LogUtils.e(TAG, "binTreeSortDone");
        tvBinTreeIsSame.setText(isSameTree + "");
    }

    @Override
    public void isSymmetricDone(boolean isSymmetric) {
        LogUtils.e(TAG, "binTreeSortDone");
        tvBinTreeIsSymmetric.setText(isSymmetric + "");
    }

    @Override
    public void levelOrderDone(String text) {
        LogUtils.e(TAG, "levelOrderDone");
        tvBinTreeLevelOrder.setText("levelOrderDone:" + text);
    }

    @Override
    public void levelOrderBottomDone(String text) {
        LogUtils.e(TAG, "levelOrderBottomDone");
        tvBinTreeLevelOrderZ.setText("levelOrderBottomDone:" + text);
    }


    @Override
    public void zigzagLevelOrderDone(String text) {
        LogUtils.e(TAG, "zigzagLevelOrderDone");
        tvBinTreeLevelOrderZ.setText("zigzagLevelOrderDone:" + text);
    }

    @Override
    public void maxDepthDone(int depth) {
        LogUtils.e(TAG, "maxDepthDone");
        tvBinTreeMaxDepth.setText(depth + "");
    }

    @Override
    public void minDepthDone(int depth) {
        tvBinTreeSort.setText("minDepthDone=" + depth);
    }

    @Override
    public void isBalancedDone(boolean isBalanced) {
        LogUtils.e(TAG, "isBalancedDone");
        tvCount1InBinary.setText("isBalancedDone：" + isBalanced);
    }

    @Override
    public void countOneInBinaryDone() {
        LogUtils.e(TAG, "countOneInBinaryDone");
    }

    @Override
    public void buildTreePreInDone(BinTreeNode binTreeNode) {
        LogUtils.e(TAG, "buildTreePreInDone");
    }

    @Override
    public void buildTreeNullDone(BinTreeNode binTreeNode) {
        LogUtils.e(TAG, "buildTreeNullDone");
        tvBinTreeCreate.setText(binTreeNode + "");
    }

    @Override
    public void buildTreeInPosstDone(BinTreeNode binTreeNode) {
        LogUtils.e(TAG, "buildTreeInPosstDone");
    }

    @Override
    public void sortedArrayToBSTDone(BinTreeNode binTreeNode) {
        LogUtils.e(TAG, "sortedArrayToBSTDone");
    }

    @Override
    public void sortedListToBSTDone(BinTreeNode binTreeNode) {
        LogUtils.e(TAG, "sortedListToBSTDone");
    }

    @Override
    public void maxSumDone() {
        LogUtils.e(TAG, "maxSumDone");
    }

    @Override
    public void twoSumDone(int[] arrInt) {
        if (arrInt != null) {
            for (int i = 0; i < arrInt.length; i++) {
                LogUtils.e(TAG, "twoSumDone---i=" + arrInt[i]);
            }
        }
    }

    @Override
    public void addTwoNumbersDone(String str) {
        LogUtils.e(TAG, "addTwoNumbersDone：" + str);
    }

    @Override
    public void lengthOfLongestSubstringDone(int result) {
        LogUtils.e(TAG, "lengthOfLongestSubstringDone：" + result);
    }

    @Override
    public void lengthOfLongestSubstring2Done(int result) {
        LogUtils.e(TAG, "lengthOfLongestSubstring2Done：" + result);
    }

    @Override
    public void findMedianSortedArraysDone(double result) {
        LogUtils.e(TAG, "findMedianSortedArraysDone：" + result);
    }

    @Override
    public void doReverserDone(String result) {
        LogUtils.e(TAG, "doReverserDone：" + result);
    }

    @Override
    public void bracketCheckerDone() {
        LogUtils.e(TAG, "bracketCheckerDone：");
    }

    @Override
    public void doTransDone(String result) {
        LogUtils.e(TAG, "doTransDone：" + result);
    }

    @Override
    public void doParseDone(int result) {
        LogUtils.e(TAG, "doParseDone：" + result);
    }

    @Override
    public void queueTestDone() {
        LogUtils.e(TAG, "queueTestDone：");
    }

    @Override
    public void queuePriorityTestDone() {
        LogUtils.e(TAG, "queuePriorityTestDone：");
    }

    @Override
    public void linkListTestDone() {
        LogUtils.e("linkListTestDone：");
    }

    @Override
    public void doubleEndLinkListTestDone() {
        LogUtils.e("doubleEndLinkListTestDone：");
    }

    @OnClick({R.id.tv_data_algorithm_insert_sort_1, R.id.tv_data_algorithm_bubble_sort_1,
            R.id.tv_data_algorithm_bubble_sort_2, R.id.tv_data_algorithm_quick_sort,
            R.id.tv_data_algorithm_selection_sort, R.id.tv_data_algorithm_shell_sort,
            R.id.tv_data_algorithm_sequential_sort, R.id.tv_bin_tree_sort, R.id.tv_bin_tree_is_same,
            R.id.tv_bin_tree_is_symmetric, R.id.tv_bin_tree_level_order, R.id.tv_bin_tree_level_order_z,
            R.id.tv_bin_tree_max_depth, R.id.tv_bin_tree_create, R.id.tv_bin_tree_create_bst,
            R.id.tv_count_1_in_binary})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_data_algorithm_insert_sort_1:
                iDataAlgorithmPresenter.insertSort(new int[]{5, 3, 1, 7, 4, 8, 2});
                textbookSettingDB.insert();
                break;
            case R.id.tv_data_algorithm_bubble_sort_1:
                iDataAlgorithmPresenter.bubbleSort1(new int[]{5, 3, 1, 7, 4, 8, 2});
                LogUtils.e("sqlite","====="+textbookSettingDB.select());
                break;
            case R.id.tv_data_algorithm_bubble_sort_2:
                iDataAlgorithmPresenter.bubbleSort2(new int[]{5, 3, 1, 7, 4, 8, 2});
                textbookSettingDB2.insert();
                break;
            case R.id.tv_data_algorithm_quick_sort:
                iDataAlgorithmPresenter.quickSort(new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_data_algorithm_selection_sort:
                iDataAlgorithmPresenter.selectionSort(new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_data_algorithm_shell_sort:
                iDataAlgorithmPresenter.shellSort(new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_data_algorithm_sequential_sort:
                iDataAlgorithmPresenter.sequentialSort(10, new int[]{5, 3, 1, 7, 4, 8, 2});
                iDataAlgorithmPresenter.sequentialSort(7, new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_bin_tree_sort:
                iDataAlgorithmPresenter.binTreeSort(new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_bin_tree_is_same:
                iDataAlgorithmPresenter.isSameTree(new int[]{5, 3, 1, 7, 4, 8, 2}, new int[]{5, 3, 1, 7, 4, 8, 3});
                break;
            case R.id.tv_bin_tree_is_symmetric:
                iDataAlgorithmPresenter.isSymmetric(new int[]{1, 2, 2, 3, 4, 7, 3});
                break;
            case R.id.tv_bin_tree_level_order:
                iDataAlgorithmPresenter.levelOrder(new int[]{1, 2, 3, 4, 5, 6, 7});
                iDataAlgorithmPresenter.levelOrderBottom(new int[]{1, 2, 3, 4, 5, 6, 7});
                break;
            case R.id.tv_bin_tree_level_order_z:
                iDataAlgorithmPresenter.zigzagLevelOrder(new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_bin_tree_max_depth:
                iDataAlgorithmPresenter.maxDepth(new int[]{5, 3, 1, 7, 4, 8, 2, 1});
                iDataAlgorithmPresenter.isBalanced(new int[]{5, 3, 1, 7, 4, 8, 2, 1});
                iDataAlgorithmPresenter.minDepth(new int[]{5, 3, 1, 7, 4, 8, 2, 1, 9, 10, 22, 88, 81, 82, 83, 84});
                break;
            case R.id.tv_bin_tree_create:
                //new int[]{5, 3, 1, 7, 4, 8, 2}
                //先序遍历：{5,3,7,4,1,8,2}
                //中序遍历：{7,3,4,5,8,1,2}
                //后序遍历：{7,4,3,8,2,1,5}
                iDataAlgorithmPresenter.buildTreePreIn(new int[]{5, 3, 7, 4, 1, 8, 2}, new int[]{7, 3, 4, 5, 8, 1, 2});
                iDataAlgorithmPresenter.buildTreeInPosst(new int[]{7, 3, 4, 5, 8, 1, 2}, new int[]{7, 4, 3, 8, 2, 1, 5});
                iDataAlgorithmPresenter.buildTreeNull(new int[]{7, 3, 4, 5, 8, 1, 2}, new int[]{7, 4, 3, 8, 2, 1, 5});
                break;
            case R.id.tv_bin_tree_create_bst:
                iDataAlgorithmPresenter.sortedArrayToBST(new int[]{2, 4, 6, 7, 8, 9, 10, 11, 12});
                iDataAlgorithmPresenter.sortedListToBST(new int[]{2, 4, 6, 7, 8, 9, 10, 11, 12});
                iDataAlgorithmPresenter.findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 5, 6});
                break;
            case R.id.tv_count_1_in_binary:
//                iDataAlgorithmPresenter.countOneInBinary(0B11111111_01010101);
//                iDataAlgorithmPresenter.maxSum(new int[]{2});
//                iDataAlgorithmPresenter.maxSum(new int[]{5, 3});
                iDataAlgorithmPresenter.maxSum(new int[]{5, 3, 1, 7, 4, 8, 2, 10, 3, 11, 34});
                iDataAlgorithmPresenter.twoSum(new int[]{5, 3, 1, 7, 4, 8, 2, 10, 11, 34}, 14);
                iDataAlgorithmPresenter.addTwoNumbers();
                iDataAlgorithmPresenter.lengthOfLongestSubstring("2dwhdi943hrandjnjnjnjcnenjheiu");
                iDataAlgorithmPresenter.lengthOfLongestSubstring2("hfdbvhabefgqbbbbdhebhbehba");
                iDataAlgorithmPresenter.doReverser("12345678");
                iDataAlgorithmPresenter.bracketChecker("1{[(23)45]67})8");
                iDataAlgorithmPresenter.queueTest(new long[]{10, 20, 30, 40, 50}, new long[]{60, 70, 80, 90});
                iDataAlgorithmPresenter.queuePriorityTest(new long[]{90, 50, 12, 30, 45, 56, 17, 80, 47, 18});
//                iDataAlgorithmPresenter.doTrans("A*(B+C)");
//                iDataAlgorithmPresenter.doTrans("(3+4)*5");//34+5*
                iDataAlgorithmPresenter.doTrans("(3*(4+5)-6/(1+2)");//345+*612+/-
                iDataAlgorithmPresenter.linkListTest(new int[]{22, 44, 66, 88}, new double[]{2.99, 4.99, 6.99, 8.99}, 44, 66);
                iDataAlgorithmPresenter.doubleEndLinkListTest(new int[]{22, 44, 66, 88}, new double[]{2.99, 4.99, 6.99, 8.99, 9.99});
//                iDataAlgorithmPresenter.findMedianSortedArrays(new int[]{},new int[]{});
//                iDataAlgorithmPresenter.findMedianSortedArrays(new int[]{1,2,3,4,5},new int[]{});
//                iDataAlgorithmPresenter.findMedianSortedArrays(new int[]{1,2,3,4,5,6,7,8,9},new int[]{});
//                iDataAlgorithmPresenter.findMedianSortedArrays(new int[]{1,2,3,4,5,6,7,8,9},new int[]{1,2,3,4,5,6});
                break;
        }
    }
}
