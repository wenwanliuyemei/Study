package com.xm.study.dataalgorithm.model.stack;

/**
 * @author: xm on 2018/1/16.
 * @describe: 栈（数组实现）
 */

public class StackXArray {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackXArray(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}