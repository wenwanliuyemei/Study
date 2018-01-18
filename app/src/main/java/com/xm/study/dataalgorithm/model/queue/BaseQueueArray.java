package com.xm.study.dataalgorithm.model.queue;

/**
 * @author: xm on 2018/1/18.
 * @describe:
 */

public abstract class BaseQueueArray {

    public int maxSize;
    public long[] queArray;

    public BaseQueueArray() {
    }

    public abstract void insert(long i);

    public abstract long remove();

    public abstract boolean isEmpty();

    public abstract boolean isFull();

    public abstract long peek();
}
