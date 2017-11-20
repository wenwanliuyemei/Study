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

    private IDataAlgorithmPresenter iDataAlgorithmPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_algorithm);
        ButterKnife.bind(this);

        iDataAlgorithmPresenter = new DataAlgorithmPresenterCompl(this, this);
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
        tvBinTreeLevelOrder.setText(text);
    }


    @Override
    public void zigzagLevelOrderDone(String text) {
        LogUtils.e(TAG, "zigzagLevelOrderDone");
        tvBinTreeLevelOrderZ.setText(text);
    }

    @Override
    public void maxDepthDone(int depth) {
        LogUtils.e(TAG, "maxDepthDone");
        tvBinTreeMaxDepth.setText(depth + "");
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
    public void maxSumDone() {
        LogUtils.e(TAG, "maxSumDone");
    }

    @OnClick({R.id.tv_data_algorithm_insert_sort_1, R.id.tv_data_algorithm_bubble_sort_1,
            R.id.tv_data_algorithm_bubble_sort_2, R.id.tv_data_algorithm_quick_sort,
            R.id.tv_data_algorithm_selection_sort, R.id.tv_data_algorithm_shell_sort,
            R.id.tv_data_algorithm_sequential_sort, R.id.tv_bin_tree_sort, R.id.tv_bin_tree_is_same,
            R.id.tv_bin_tree_is_symmetric, R.id.tv_bin_tree_level_order, R.id.tv_bin_tree_level_order_z,
            R.id.tv_bin_tree_max_depth, R.id.tv_bin_tree_create, R.id.tv_count_1_in_binary})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_data_algorithm_insert_sort_1:
                iDataAlgorithmPresenter.insertSort(new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_data_algorithm_bubble_sort_1:
                iDataAlgorithmPresenter.bubbleSort1(new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_data_algorithm_bubble_sort_2:
                iDataAlgorithmPresenter.bubbleSort2(new int[]{5, 3, 1, 7, 4, 8, 2});
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
                iDataAlgorithmPresenter.levelOrder(new int[]{1, 2, 2, 3, 4, 7, 3});
                break;
            case R.id.tv_bin_tree_level_order_z:
                iDataAlgorithmPresenter.zigzagLevelOrder(new int[]{5, 3, 1, 7, 4, 8, 2});
                break;
            case R.id.tv_bin_tree_max_depth:
                iDataAlgorithmPresenter.maxDepth(new int[]{5, 3, 1, 7, 4, 8, 2, 1});
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
            case R.id.tv_count_1_in_binary:
//                iDataAlgorithmPresenter.countOneInBinary(0B11111111_01010101);
//                iDataAlgorithmPresenter.maxSum(new int[]{2});
//                iDataAlgorithmPresenter.maxSum(new int[]{5, 3});
                iDataAlgorithmPresenter.maxSum(new int[]{5, 3, 1, 7, 4, 8, 2, 10, 3, 11, 34});
                break;
        }
    }
}
