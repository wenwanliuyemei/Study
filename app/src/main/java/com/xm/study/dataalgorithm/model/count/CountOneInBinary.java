package com.xm.study.dataalgorithm.model.count;

/**
 * @author: xm on 2017/9/22.
 * @describe: 二进制数中"1"的位数
 */

public class CountOneInBinary {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
