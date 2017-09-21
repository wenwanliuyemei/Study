package com.xm.study.dataalgorithm.model.sort;

import android.util.Log;

import java.util.Arrays;

/**
 * 作者：xm on 2017/3/14 11:49
 * 描述：冒泡排序
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，
 * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 */
public class BubbleSort {
    private final String TAG = this.getClass().getSimpleName();
    private static BubbleSort bubbleSort = new BubbleSort();

    private BubbleSort() {

    }

    public static BubbleSort getInstance() {
        return bubbleSort;
    }

    public int[] bubbleSort1(int[] arrInt) {
        int temp;
        Log.e(TAG, "bubbleSort1--排序前--arrInt=" + Arrays.toString(arrInt));
        for (int i = arrInt.length - 1; i >= 1; i--) {
            Log.e(TAG, "bubbleSort1--外循环--i=" + i);
            for (int j = 0; j < i; j++) {
                if (arrInt[j] > arrInt[j + 1]) {
                    temp = arrInt[j];
                    arrInt[j] = arrInt[j + 1];
                    arrInt[j + 1] = temp;
                }
                Log.e(TAG, "bubbleSort1--内循环--j=" + j + ",arrInt=" + Arrays.toString(arrInt));
            }
            Log.e(TAG, "bubbleSort1--外循环--i=" + i + ",arrInt=" + Arrays.toString(arrInt));
        }
        Log.e(TAG, "bubbleSort1--排序后--arrInt=" + Arrays.toString(arrInt));
        return arrInt;
    }

    public int[] bubbleSort2(int[] arrInt) {
        int temp;
        Log.e(TAG, "bubbleSort2--排序前--arrInt=" + Arrays.toString(arrInt));
        for (int i = 0; i < arrInt.length; i++) {//趟数
            Log.e(TAG, "bubbleSort2--外循环--i=" + i);
            for (int j = 0; j < arrInt.length - i-1; j++) {//比较次数
                if (arrInt[j] > arrInt[j + 1]) {
                    temp = arrInt[j];
                    arrInt[j] = arrInt[j + 1];
                    arrInt[j + 1] = temp;
                }
                Log.e(TAG, "bubbleSort2--内循环--j=" + j + ",arrInt=" + Arrays.toString(arrInt));
            }
            Log.e(TAG, "bubbleSort2--外循环--i=" + i + ",arrInt=" + Arrays.toString(arrInt));
        }
        Log.e(TAG, "bubbleSort2--排序后--arrInt=" + Arrays.toString(arrInt));
        return arrInt;
    }
}
