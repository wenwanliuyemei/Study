package com.xm.study.dataalgorithm.model.stack;

import com.xm.utils.LogUtils;

import java.lang.reflect.Array;

/**
 * @author: xm on 2018/1/16.
 * @describe: 栈（数组实现）
 */

public class StackXArray<T> {

    private int maxSize;
    private T[] stackArray;
    private int top;

    public StackXArray(Class<T> type, int max) {
        maxSize = max;
        stackArray = (T[]) Array.newInstance(type, maxSize);
        top = -1;
    }

    public void push(T j) {
        stackArray[++top] = j;
    }

    public T pop() {
        return stackArray[top--];
    }

    public T peek() {
        return stackArray[top];
    }

    public T peekN(int n) {
        return stackArray[n];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int size() {
        return top + 1;
    }

    public void displayStack(String s) {
        LogUtils.e(s);
        LogUtils.e("Stack (bottom-->top):");
        for (int i = 0; i < size(); i++) {
            LogUtils.e(peekN(i) + "");
        }
    }
}
