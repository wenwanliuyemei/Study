package com.xm.study.dataalgorithm.model.queue;

/**
 * @author: xm on 2018/1/18.
 * @describe: 优先级队列
 */

public class QueuePriority extends BaseQueueArray {

    private int nItems;

    public QueuePriority(int size) {
        super();
        maxSize = size;
        queArray = new long[maxSize];
        nItems = 0;
    }

    @Override
    public void insert(long item) {
        int i;
        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (i = nItems - 1; i >= 0; i--) {
                if (item > queArray[i]) {
                    queArray[i + 1] = queArray[i];
                } else {
                    break;
                }
            }
            queArray[i + 1] = item;
            nItems++;
        }
    }

    @Override
    public long remove() {
        return queArray[--nItems];
    }

    @Override
    public long peek() {
        return queArray[nItems - 1];
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }

    @Override
    public boolean isFull() {
        return nItems == maxSize;
    }
}
