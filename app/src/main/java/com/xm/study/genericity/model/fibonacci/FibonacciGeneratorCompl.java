package com.xm.study.genericity.model.fibonacci;

import com.xm.study.genericity.model.interfacee.IGenerator;

/**
 * 作者：xm on 2017/1/16 16:08
 * 描述：
 */
public class FibonacciGeneratorCompl implements IGenerator<Integer> {
    private int count=0;

    private int fibonacci(int n){
       if(n<2){
           return 1;
       } else{
           return fibonacci(n-2)+fibonacci(n-1);
       }
    }

    @Override
    public Integer next() {
        return fibonacci(count++);
    }
}
