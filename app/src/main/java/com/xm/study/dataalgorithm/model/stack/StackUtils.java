package com.xm.study.dataalgorithm.model.stack;

import android.content.Context;

import com.xm.study.dataalgorithm.model.list.LinkListDatasTest;
import com.xm.study.dataalgorithm.model.list.LinkStack;
import com.xm.utils.LogUtils;

/**
 * @author: xm on 2018/1/16.
 * @describe:
 */

public class StackUtils {

    public static String doReverser(String in) {
        int stackSize = in.length();
        StackXArray<Character> stackXArray = new StackXArray<Character>(Character.class, stackSize);

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
        StackXArray<Character> stackXArray = new StackXArray<Character>(Character.class, stackSize);
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
                            LogUtils.e("StackUtils:bracketChecker", "Error: " + ch + " at " + i + " ,no match");
                        } else {
                        }
                    } else {
                        LogUtils.e("StackUtils:bracketChecker", "Error: " + ch + " at " + i + " ,stackXArray is empty");
                    }
                    break;
            }
        }
        if (!stackXArray.isEmpty()) {
            LogUtils.e("StackUtils:bracketChecker", "Error: missing right delimiter");
        }
    }

    /**
     * 后缀表达式
     *
     * @param input
     * @return
     */
    public static String doTrans(String input) {
        if (input == null || input.length() == 0) {
            LogUtils.e("StackUtils--doTrans:", "input is null ,or length is 0.");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        StackXArray<Character> stackXArray = new StackXArray<Character>(Character.class, input.length());

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

    /**
     * 入栈
     *
     * @param stackXArray
     * @param stringBuffer
     * @param opThis
     * @param prec1
     */
    public static void gotOper(StackXArray stackXArray, StringBuffer stringBuffer, char opThis, int prec1) {
        while (!stackXArray.isEmpty()) {
            char opTop = (char) stackXArray.pop();
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

    /**
     * 出栈
     *
     * @param stackXArray
     * @param stringBuffer
     * @param ch
     */
    public static void gotParen(StackXArray stackXArray, StringBuffer stringBuffer, char ch) {
        while (!stackXArray.isEmpty()) {
            char chx = (char) stackXArray.pop();
            if (chx == '(') {
                break;
            } else {
                stringBuffer.append(chx);
            }
        }
    }


    public static int doParse(String input) {
        if (input == null || input.length() == 0) {
            LogUtils.e("StackUtils--doParse:", "input is null ,or length is 0.");
            return (int) Double.NEGATIVE_INFINITY;
        }
        StackXArray<Integer> stackXArray = new StackXArray<Integer>(Integer.class, input.length());
        char ch;

        int num1, num2, interAns;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            stackXArray.displayStack(ch + " ");
            if (ch >= '0' && ch <= '9') {
                stackXArray.push(ch - '0');
            } else if (stackXArray.size() > 1) {
                num2 = stackXArray.pop();
                num1 = stackXArray.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                stackXArray.push(interAns);
            } else {

            }
        }
        interAns = stackXArray.pop();
        return interAns;
    }

    public static void linkStackTest(Context context, int[] arrInt, double[] arrDou) {
        LinkListDatasTest linkListDatasTest = new LinkListDatasTest(context, arrInt, arrDou).invoke();
        if (linkListDatasTest.is()) return;
        int length = linkListDatasTest.getLength();
        LinkStack linkStack = new LinkStack();
        for (int i = 0; i < length; i++) {
            linkStack.push(arrInt[i], arrDou[i]);
        }
        linkStack.displayLinkStack();
        for (int i = 0; i < length / 2; i++) {
            linkStack.pop();
        }
        linkStack.displayLinkStack();
    }
}
