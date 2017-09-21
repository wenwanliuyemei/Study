package com.xm.study.dataalgorithm.model.sort;

import android.util.Log;

import java.util.Arrays;

/**
 * 作者：xm on 2017/3/15 10:37
 * 描述：希尔排序
 * 先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差d。
 * 对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，
 * 在每组中再进行直接插入排序。
 * 当增量减到1时，进行直接插入排序后，排序完成。
 */
public class ShellSort {

    private final String TAG = this.getClass().getSimpleName();

    private static ShellSort shellSort = new ShellSort();

    private ShellSort() {
    }

    public static ShellSort getShellSort() {
        return shellSort;
    }

    public int[] shellSort(int[] array) {
        double d1 = array.length;
        int temp = 0;
        Log.e(TAG, "shellSort--排序前--d1=" + d1);
        Log.e(TAG, "shellSort--排序前--array=" + Arrays.toString(array));
        while (true) {
            d1 = Math.ceil(d1 / 2); // Math.ceil()向上取整计算
            Log.e(TAG, "shellSort--while前--d1=" + d1);
            int d = (int) d1;
            Log.e(TAG, "shellSort--while前--d1=" + d1);
            Log.e(TAG, "shellSort--while前--array=" + Arrays.toString(array));
            for (int x = 0; x < d; x++) {
                Log.e(TAG, "shellSort--for1前--x=" + x + ",array=" + Arrays.toString(array));
                for (int i = x + d; i < array.length; i += d) {
                    Log.e(TAG, "shellSort--for2前--i=" + i + ",array=" + Arrays.toString(array));
                    int j = i - d;
                    Log.e(TAG, "shellSort--for2前--j=" + j + ",array=" + Arrays.toString(array));
                    temp = array[i];
                    Log.e(TAG, "shellSort--for2前--temp=" + temp + ",array=" + Arrays.toString(array));
                    for (; j >= 0 && temp < array[j]; j -= d) {
                        array[j + d] = array[j];
                        Log.e(TAG, "shellSort--for3--array[j]=" + array[j] + ",temp=" + temp + ",array=" + Arrays.toString(array));
                    }
                    array[j + d] = temp;
                    Log.e(TAG, "shellSort--for2后--array[j+d]=" + array[j + d] + ",temp=" + temp + ",array=" + Arrays.toString(array));
                }
                Log.e(TAG, "shellSort--for1后--x=" + x + ",array=" + Arrays.toString(array));
            }
            Log.e(TAG, "shellSort--while后--array=" + Arrays.toString(array));
            if (d == 1)
                break;
        }
        Log.e(TAG, "shellSort--排序后--array=" + Arrays.toString(array));
        return array;
    }
}
