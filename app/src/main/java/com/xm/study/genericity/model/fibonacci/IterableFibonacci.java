package com.xm.study.genericity.model.fibonacci;

import java.util.Iterator;

/**
 * 作者：xm on 2017/1/17 11:37
 * 描述：适配器方法
 */
public class IterableFibonacci extends FibonacciGeneratorCompl implements Iterable<Integer>{
    private int n;
    public IterableFibonacci(int count){
        n=count;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n>0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
