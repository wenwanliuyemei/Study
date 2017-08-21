package com.xm.study.datastructure.model.string;

/**
 * 作者：xm on 2017/2/9 16:34
 * 描述：十六进制转储工具
 */
public class HexOutput {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05x:", n));
            }
            result.append(String.format("%02X", b));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }
}
