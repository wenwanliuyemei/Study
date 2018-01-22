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
                            LogUtils.e("StackXArrayUtils:bracketChecker", "Error: " + ch + " at " + i + " ,no match");
                        } else {
                        }
                    } else {
                        LogUtils.e("StackXArrayUtils:bracketChecker", "Error: " + ch + " at " + i + " ,stackXArray is empty");
                    }
                    break;
            }
        }
        if (!stackXArray.isEmpty()) {
            LogUtils.e("StackXArrayUtils:bracketChecker", "Error: missing right delimiter");
        }
    }

    public static String doTrans(String input) {
        if (input == null || input.length() == 0) {
            LogUtils.e("StackXArrayUtils--doTrans:", "input is null ,or length is 0.");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        StackXArray stackXArray = new StackXArray(input.length());

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            stackXArray.displayStack("For " + ch + " ");

            switch (ch) {
                case '+':
                case '-':
                    gotOper(stackXArray, stringBuffer, ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(stackXArray, stringBuffer, ch, 2);
                    break;
                case '(':
                    stackXArray.push(ch);
                    break;
                case ')':
                    gotParen(stackXArray, stringBuffer, ch);
                    break;
                default:
                    stringBuffer.append(ch);
                    break;
            }
        }

        while (!stackXArray.isEmpty()) {
            stackXArray.displayStack("While ");
            stringBuffer.append(stackXArray.pop());
        }
        stackXArray.displayStack("End ");
        return stringBuffer.toString();
    }

    public static void gotOper(StackXArray stackXArray, StringBuffer stringBuffer, char opThis, int prec1) {
        while (!stackXArray.isEmpty()) {
            char opTop = stackXArray.pop();
            if (opTop == '(') {
                stackXArray.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    stackXArray.push(opTop);
                    break;
                } else {
                    stringBuffer.append(opTop);
                }
            }
        }
        stackXArray.push(opThis);
    }

    public static void gotParen(StackXArray stackXArray, StringBuffer stringBuffer, char ch) {
        while (!stackXArray.isEmpty()) {
            char chx = stackXArray.pop();
            if (chx == '(') {
                break;
            } else {
                stringBuffer.append(chx);
            }
        }
    }
}
