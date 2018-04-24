package com.xm.study.dataalgorithm.model.sort;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by zhangxiumei on 2017/3/13.
 * 插入排序
 * 一般情况下将数组的第一个元素作为启始元素,从第二个元素开始依次插入。
 * 由于要插入到的数组是已经排好序的,所以只是要从右向左找到比插入点小(对升序而言)的第一个数组元素就插入到其后面，
 * 直到将最后一个数组元素插入到数组中,整个排序过程就算完成。
 */

public class InsertSort {

    private final String TAG = this.getClass().getSimpleName();
    private static InsertSort insertSort = new InsertSort();

    private InsertSort() {

    }

    public static InsertSort getInstance() {
        return insertSort;
    }

    public int[] insertSort(int[] arrInt) {

        int i = 0, j = 0;//i：已排序的length。j：已排序的最后一个元素的下标。
        int insertNote;//要插入的数据
        int[] arrTemp = arrInt;
        //从数组的第二个元素开始循环，将数组中的元素插入
        for (i = 1; i < arrTemp.length; i++) {
            Log.e(TAG, "j=" + j);
            //设置数组的第二个元素为第一次循环，要比较的数据
            insertNote = arrTemp[i];
            j = i - 1;
            while (j >= 0 && insertNote < arrTemp[j]) {
                //如果要比较的数据小于第j个元素，就将第j个元素向后移
                arrTemp[j + 1] = arrTemp[j];
                j--;
                Log.e(TAG, "排序中--while--j=" + j + ",arrTemp=" + Arrays.toString(arrTemp));

            }
            //直到要插入的数据不小于第j个元素，将insertNote插入到数组中
            Log.e(TAG, "j=" + j);
            arrTemp[j + 1] = insertNote;
            Log.e(TAG, "排序中--for--j=" + j + ",arrTemp=" + Arrays.toString(arrTemp));
        }
        Log.e(TAG, "排序后--arrTemp=" + Arrays.toString(arrTemp));
        return arrTemp;
    }
}
