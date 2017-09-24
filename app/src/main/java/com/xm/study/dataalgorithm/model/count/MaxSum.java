package com.xm.study.dataalgorithm.model.count;

import com.xm.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xm on 2017/9/22.
 * @describe: 题目大意：
 * 你是一名专业强盗，计划沿着一条街打家劫舍。每间房屋都储存有一定数量的金钱。
 * 唯一能阻止你打劫的约束条件就是：
 * 由于房屋之间有安全系统相连，如果同一个晚上有两间相邻的房屋被闯入，
 * 它们就会自动联络警察。
 * 因此不可以打劫相邻的房屋。
 * <p>
 * 给定一列非负整数，代表每间房屋的金钱数，计算出在不惊动警察的前提下一晚上最多可以打劫到的金钱数。
 * 解题思路：动态规划（Dynamic Programming）
 * 状态转移方程：dp[i] = max(dp[i - 2], dp[i - 3]) + num[i] 【A】
 * 其中，dp[i]表示打劫到第i间房屋时累计取得的金钱最大值。
 * (第 i 个位置的 max 值是由 max(i-2, i-3) 加上 i 位置的值决定，以此类推)
 */

public class MaxSum {

    public static int maxSum(int[] arrInt) {

        if (arrInt == null || arrInt.length == 0) {
            return 0;
        }
        if (arrInt.length == 1) {
            return arrInt[0];
        } else if (arrInt.length == 2) {
            return Math.max(arrInt[0], arrInt[1]);
        }
        arrInt[2] += arrInt[0];
        int i = 3;
        for (; i < arrInt.length; i++) {
            arrInt[i] += Math.max(arrInt[i - 2], arrInt[i - 3]);
        }
        for (int j = 0; j < arrInt.length; j++) {
            LogUtils.e("arrInt[" + j + "]=" + arrInt[j]);
        }
        return Math.max(arrInt[i - 2], arrInt[i - 1]);
    }

    public static Map<Integer, List<Object>> maxSum2(int[] arrInt) {
        List<Object> maxSumList = new ArrayList<>();
        List<Object> idList = new ArrayList<>();
        Map<Integer, List<Object>> result = new HashMap<>();

        if (arrInt == null || arrInt.length == 0) {
            return null;
        }
        if (arrInt.length == 1) {
            MaxSumNode maxSumNode = new MaxSumNode();
            maxSumNode.setData(arrInt[0]);
            maxSumNode.setId(0);
            maxSumNode.setOriginalData(arrInt[0]);
            maxSumList.add(maxSumNode);
            idList.add(maxSumNode.getId());
            result.put(0, maxSumList);
            result.put(1, idList);
            return result;
        } else if (arrInt.length == 2) {
            MaxSumNode maxSumNode = new MaxSumNode();
            maxSumNode.setData(Math.max(arrInt[0], arrInt[1]));
            maxSumNode.setId(arrInt[0] > arrInt[1] ? 0 : 1);
            maxSumNode.setOriginalData(arrInt[maxSumNode.getId()]);
            maxSumList.add(maxSumNode);
            idList.add(maxSumNode.getId());
            result.put(0, maxSumList);
            result.put(1, idList);
            return result;
        }
        arrInt[2] += arrInt[0];
        List<Object> dataTemp = new ArrayList<>();
        MaxSumNode maxSumNodeTemp = new MaxSumNode();
        for (int j = 0; j < 3; j++) {
            maxSumNodeTemp.setData(arrInt[j]);
            maxSumNodeTemp.setId(j);
            maxSumNodeTemp.setOriginalData(arrInt[maxSumNodeTemp.getId()]);
            dataTemp.add(maxSumNodeTemp);
        }
        int i = 3;
        for (; i < arrInt.length; i++) {
            maxSumNodeTemp.setId(i);
            maxSumNodeTemp.setOriginalData(arrInt[maxSumNodeTemp.getId()]);
            arrInt[i] += Math.max(arrInt[i - 2], arrInt[i - 3]);
            maxSumNodeTemp.setData(arrInt[i]);
            dataTemp.add(maxSumNodeTemp);
        }
        for (int j = 0; j < arrInt.length; j++) {
            LogUtils.e("arrInt[" + j + "]=" + arrInt[j]);
        }
        maxSumNodeTemp.setData(Math.max(arrInt[i - 2], arrInt[i - 1]));
        maxSumNodeTemp.setId(arrInt[i - 2] > arrInt[i - 1] ? (i - 2) : (i - 1));
        maxSumNodeTemp.setOriginalData(arrInt[maxSumNodeTemp.getId()]);
        maxSumList.add(maxSumNodeTemp);
        result.put(0, maxSumList);

        for (int j=maxSumNodeTemp.getId()-1;j>0;j--){
            if(((MaxSumNode)dataTemp.get(j)).getData()==(maxSumNodeTemp.getData()-maxSumNodeTemp.getOriginalData())){
                idList.add(j);
                maxSumNodeTemp= (MaxSumNode) dataTemp.get(j);
            }
        }
        result.put(1, idList);
        return result;
    }

}
