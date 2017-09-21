package com.xm.study.dataalgorithm.presenter;

/**
 * Created by zhangxiumei on 2017/3/13.
 */

public interface IDataAlgorithmPresenter {

    public void insertSort(int[] arr);

    public void bubbleSort1(int[] arr);

    public void bubbleSort2(int[] arr);

    public void quickSort(int[] arr);

    public void selectionSort(int[] arr);

    public void shellSort(int[] arr);

    public void sequentialSort(int key, int[] arr);

    void binTreeSort(int[] arr);
}
