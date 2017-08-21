package com.xm.study.dataalgorithm.model;

import android.util.Log;

import java.util.Arrays;

/**
 * 作者：xm on 2017/3/15 10:56
 * 描述：顺序查找排序
 * 从数据序列的第一个数开始，将数据集合或序列中的每一个数据与关键值一一匹配，
 * 若找到匹配数据，则查找成功，否则失败。
 * 该算法为穷举算法，用于较少的数据个数。
 */
public class SequentialSort {

    private final String TAG = this.getClass().getSimpleName();
    private static SequentialSort sequentialSort = new SequentialSort();

    private SequentialSort() {
    }

    public static SequentialSort getInstance() {
        return sequentialSort;
    }

    public int sequentialSort(int key, int[] array) {
        Log.e(TAG, "sequentialSort--排序前--key=" + key + ",arrInt=" + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                Log.e(TAG, "sequentialSort--i=" + i);
                return i;
            }
        }
        return -1;
    }

}
