package com.xm.study.dataalgorithm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.dataalgorithm.presenter.DataAlgorithmPresenterCompl;
import com.xm.study.dataalgorithm.presenter.IDataAlgorithmPresenter;
import com.xm.study.dataalgorithm.view.IDataAlgorithmView;

/**
 * 数据算法
 */
public class DataAlgorithmActivity extends BaseActivity implements IDataAlgorithmView {

    private final String TAG = this.getClass().getSimpleName();

    private IDataAlgorithmPresenter iDataAlgorithmPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_algorithm);

        //init view 、set listener
        int[] ids = new int[]{R.id.tv_data_algorithm_insert_sort_1, R.id.tv_data_algorithm_bubble_sort_1
                , R.id.tv_data_algorithm_bubble_sort_2, R.id.tv_data_algorithm_quick_sort
                , R.id.tv_data_algorithm_selection_sort, R.id.tv_data_algorithm_shell_sort
                , R.id.tv_data_algorithm_sequential_sort};
        View[] views = new View[ids.length];
        initViewAndSetListener(views, ids);

        //init
        iDataAlgorithmPresenter = new DataAlgorithmPresenterCompl(this, this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
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
        }
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
}
