package com.xm.study.dataalgorithm.model.stack;

import com.xm.utils.LogUtils;

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

    public static void bracketChecker(String in) {
        int stackSize = in.length();
        StackXArray stackXArray = new StackXArray(stackSize);
        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stackXArray.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stackXArray.isEmpty()) {
                        char chx = stackXArray.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')) {
                            LogUtils.e("StackXArrayUtils:bracketChecker","Error: "+ch+" at "+i+" ,no match");
                        }else{
                        }
                    }else{
                        LogUtils.e("StackXArrayUtils:bracketChecker","Error: "+ch+" at "+i+" ,stackXArray is empty");
                    }
                    break;
            }
        }
        if(!stackXArray.isEmpty()){
            LogUtils.e("StackXArrayUtils:bracketChecker","Error: missing right delimiter");
        }
    }
}
