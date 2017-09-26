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
            setResult(arrInt[0], 0, maxSumList, idList, result);
            return result;
        } else if (arrInt.length == 2) {
            setResult(Math.max(arrInt[0], arrInt[1]),
                    arrInt[0] > arrInt[1] ? 0 : 1, maxSumList, idList, result);
            return result;
        }
        List<MaxSumNode> dataTemp = new ArrayList<>();
        setMaxSumNode(arrInt, dataTemp);
        MaxSumNode maxSumNode = dataTemp.get(dataTemp.get(dataTemp.size() - 2).getData()
                > dataTemp.get(dataTemp.size() - 1).getData() ? (dataTemp.size() - 2) : (dataTemp.size() - 1));
        maxSumList.clear();
        maxSumList.add(maxSumNode);
        result.put(0, maxSumList);
        while(maxSumNode.getOriginalId()!=maxSumNode.getId()){
            idList.add(maxSumNode);
            maxSumNode=dataTemp.get(maxSumNode.getOriginalId());
        }
        result.put(1, idList);
        return result;
    }

    private static void setResult(int data, int i, List<Object> maxSumList, List<Object> idList, Map<Integer, List<Object>> result) {
        MaxSumNode maxSumNode = new MaxSumNode();
        setMaxSumNode(data, i, maxSumNode);
        maxSumList.add(maxSumNode);
        idList.add(maxSumNode.getId());
        result.put(0, maxSumList);
        result.put(1, idList);
    }

    private static void setMaxSumNode(int[] arrInt, List<MaxSumNode> dataTemp) {
        for (int i = 0; i < arrInt.length; i++) {
            MaxSumNode maxSumNodeTemp = new MaxSumNode();
            if (i == 0 || i == 1) {
                setMaxSumNode(arrInt[i], i, maxSumNodeTemp);
            } else if (i == 2) {
                maxSumNodeTemp.setId(i);
                maxSumNodeTemp.setOriginalData(arrInt[i]);
                arrInt[2] += arrInt[0];
                maxSumNodeTemp.setData(arrInt[i]);
                maxSumNodeTemp.setOriginalId(0);
            } else if (i > 2) {
                maxSumNodeTemp.setId(i);
                maxSumNodeTemp.setOriginalData(arrInt[i]);
                arrInt[i] += Math.max(arrInt[i - 2], arrInt[i - 3]);
                maxSumNodeTemp.setData(arrInt[i]);
                maxSumNodeTemp.setOriginalId(arrInt[i - 2] > arrInt[i - 3] ? (i - 2) : (i - 3));
            }
            addMaxSumNode(dataTemp, maxSumNodeTemp);
        }
    }


    private static void setMaxSumNode(int data, int i, MaxSumNode maxSumNodeTemp) {
        maxSumNodeTemp.setId(i);
        maxSumNodeTemp.setOriginalData(data);
        maxSumNodeTemp.setData(data);
        maxSumNodeTemp.setOriginalId(i);
    }

    private static void addMaxSumNode(List<MaxSumNode> dataTemp, MaxSumNode maxSumNodeTemp) {
        dataTemp.add(maxSumNodeTemp);
    }

    private static List<Object> idListAdd(List<Object> idList, MaxSumNode maxSumNode) {
        List<Object> temp = new ArrayList<>();
        temp.add(maxSumNode);
        return idListAdd(idList, (MaxSumNode) idList.get(maxSumNode.getOriginalId()));
    }
}
