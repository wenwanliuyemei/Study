package com.xm.study.dataalgorithm.model.stack;

/**
 * @author: xm on 2018/1/16.
 * @describe:
 */

public class StackXArrayUtils {

    public static String doReverser(String in) {
        int stackSize = in.length();
        StackXArray stackXArray = new StackXArray(stackSize);

        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            stackXArray.push(c);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stackXArray.isEmpty()) {
            char c = stackXArray.pop();
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
