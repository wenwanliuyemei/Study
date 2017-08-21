package com.xm.study.dataalgorithm.presenter;

import android.content.Context;
import android.util.Log;

import com.xm.study.dataalgorithm.model.BubbleSort;
import com.xm.study.dataalgorithm.model.InsertSort;
import com.xm.study.dataalgorithm.model.QuickSort;
import com.xm.study.dataalgorithm.model.SelectionSort;
import com.xm.study.dataalgorithm.model.SequentialSort;
import com.xm.study.dataalgorithm.model.ShellSort;
import com.xm.study.dataalgorithm.view.IDataAlgorithmView;

import java.util.Arrays;

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
}
