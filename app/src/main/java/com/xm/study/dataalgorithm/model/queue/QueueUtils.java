package com.xm.study.dataalgorithm.model.queue;


import com.xm.utils.LogUtils;

/**
 * @author: xm on 2018/1/17.
 * @describe:
 */

public class QueueUtils {

    public static void queueTest(long[] arr1, long[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            LogUtils.e("QueueUtils--queueTest:", "arr1 is null ,or length is 0.");
            return;
        }
        QueueArray queueArray = new QueueArray(arr1.length);
        for (int i = 0; i < arr1.length; i++) {
            queueArray.insert(arr1[i]);
        }

        if (arr1.length >= 3) {
            queueArray.remove();
            queueArray.remove();
            queueArray.remove();
        } else if (arr1.length >= 2) {
            queueArray.remove();
            queueArray.remove();
        } else if (arr1.length >= 1) {
            queueArray.remove();
        }

        for (int i = 0; i < arr2.length; i++) {
            queueArray.insert(arr2[i]);
        }

        while (!queueArray.isEmpty()) {
            long temp = queueArray.remove();
            LogUtils.e("QueueUtils--queueTest:", temp + "");
        }
    }

    public static void queuePriorityTest(long[] arr) {
        if (arr == null || arr.length == 0) {
            LogUtils.e("QueueUtils--queuePriorityTest:", "arr is null ,or length is 0.");
            return;
        }
        QueuePriority queuePriority = new QueuePriority(arr.length);
        for (int i = 0; i < arr.length; i++) {
            queuePriority.insert(arr[i]);
        }

        while (!queuePriority.isEmpty()) {
            long item = queuePriority.remove();
            LogUtils.e("QueueUtils--queuePriorityTest:", item + "");
        }
    }
}
