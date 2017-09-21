package com.xm.study.dataalgorithm.model.sort;

import android.util.Log;

import java.util.Arrays;

/**
 * 作者：xm on 2017/3/15 09:56
 * 描述：选择排序
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，
 * 如此循环到倒数第二个数和最后一个数比较为止。
 */
public class SelectionSort {

    private final String TAG = this.getClass().getSimpleName();

    private static SelectionSort selectionSort = new SelectionSort();

    private SelectionSort() {
    }

    public static SelectionSort getSelectionSort() {
        return selectionSort;
    }

    public int[] selectionSort(int arrInt[]) {
        int temp;
        Log.e(TAG, "selectionSort--排序前--arrInt=" + Arrays.toString(arrInt));
        for (int i = 0; i < arrInt.length; i++) {
            Log.e(TAG, "selectionSort--外循环--排序前--i=" + i + ",arrInt=" + Arrays.toString(arrInt));
            for (int j = i + 1; j < arrInt.length; j++) {
                Log.e(TAG, "selectionSort--内循环--排序前--i=" + i + ",j=" + j + ",arrInt=" + Arrays.toString(arrInt));
                if (arrInt[i] > arrInt[j]) {
                    temp = arrInt[i];
                    arrInt[i] = arrInt[j];
                    arrInt[j] = temp;
                }
                Log.e(TAG, "selectionSort--内循环--排序后--i=" + i + ",j=" + j + ",arrInt=" + Arrays.toString(arrInt));
            }
            Log.e(TAG, "selectionSort--外循环--排序后--i=" + i + ",arrInt=" + Arrays.toString(arrInt));
        }
        return arrInt;
    }

}
