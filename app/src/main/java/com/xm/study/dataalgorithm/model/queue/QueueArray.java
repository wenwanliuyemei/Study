package com.xm.study.dataalgorithm.model.queue;

/**
 * @author: xm on 2018/1/17.
 * @describe: 队列（数组实现），有数据项计数nItems。
 */

public class QueueArray {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueArray(int size) {
        maxSize = size;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long i) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = i;
        nItems++;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }
}
