package com.xm.study.dataalgorithm.model.queue;

/**
 * @author: xm on 2018/1/17.
 * @describe: 队列（数组实现），无数据项计数nItems。
 * 让数组容量比队列的数据项个数的最大值大1。
 */

public class QueueArray2 extends BaseQueueArray{

    private int front;
    private int rear;

    public QueueArray2(int size) {
        super();
        maxSize = size+1;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    @Override
    public void insert(long i) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = i;
    }

    @Override
    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    @Override
    public long peek() {
        return queArray[front];
    }

    @Override
    public boolean isEmpty() {
        return (rear+1==front)||(front+maxSize-1==rear);
    }

    @Override
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
