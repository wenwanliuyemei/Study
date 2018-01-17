package com.xm.study.dataalgorithm.model.queue;

/**
 * @author: xm on 2018/1/17.
 * @describe: 队列（数组实现），无数据项计数nItems。
 * 让数组容量比队列的数据项个数的最大值大1。
 */

public class QueueArray2 {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public QueueArray2(int size) {
        maxSize = size+1;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long i) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = i;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (rear+1==front)||(front+maxSize-1==rear);
    }

    public boolean isFull() {
        return (rear+2==front)||(front+maxSize-2==rear);
    }

    public int size() {
        if(rear>=front){
            return rear-front+1;
        }else{
            return maxSize-front+rear+1;
        }
    }
}
