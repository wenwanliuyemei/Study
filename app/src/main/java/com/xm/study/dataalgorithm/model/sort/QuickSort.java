package com.xm.study.dataalgorithm.model.sort;

import android.util.Log;

import java.util.Arrays;

/**
 * 作者：xm on 2017/3/14 14:53
 * 描述：快速排序
 * 选择一个基准元素,通常选择第一个元素或者最后一个元素,
 * 通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素.
 * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
 */
public class QuickSort {

    private final String TAG = this.getClass().getSimpleName();
    private static QuickSort quickSort = new QuickSort();

    private QuickSort() {
    }

    public static QuickSort getQuickSort() {
        return quickSort;
    }

    public int[] quickSort(int array[]) {
        if (array.length > 1) {
            sort(array, 0, array.length - 1);
        }
        return array;
    }

    /**
     * 一趟快速排序
     *
     * @param array
     */
    private void sort(int[] array, int low, int high) {
        if (low < high) {
            Log.e(TAG, "sort--low=" + low + ",high=" + high + ",array=" + Arrays.toString(array));
            int middle = getMiddle(array, low, high);
            Log.e(TAG, "sort--middle=" + middle);
            sort(array, low, middle - 1);
            Log.e(TAG, "sort--array--1=" + Arrays.toString(array));
            sort(array, middle + 1, high);
            Log.e(TAG, "sort--array--2=" + Arrays.toString(array));
        }
    }

    /**
     * 得到中间值
     */
    private int getMiddle(int[] array, int low, int high) {
        int tmp = array[low];
        Log.e(TAG, "getMiddle--temp=" + tmp);
        Log.e(TAG, "getMiddle--0--low=" + low + ",high=" + high + ",array=" + Arrays.toString(array));
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            Log.e(TAG, "getMiddle--1--low=" + low + ",high=" + high + ",array=" + Arrays.toString(array));
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
            Log.e(TAG, "getMiddle--2--low=" + low + ",high=" + high + ",array=" + Arrays.toString(array));
        }
        array[low] = tmp;
        Log.e(TAG, "getMiddle--3--low=" + low + ",high=" + high + ",array=" + Arrays.toString(array));
        return low;
    }
}
