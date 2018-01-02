package com.xm.study.dataalgorithm.model.array;

import java.util.Arrays;

/**
 * @author: xm on 2017/12/26.
 * @describe:
 */

public class ArraysUtils {

    /**
     * 题目大意
     * 给定一个整数数组，找出其中两个数满足相加等于你指定的目标数字。
     * 要求：这个函数twoSum必须要返回能够相加等于目标数字的两个数的索引，且index1必须要小于index2。
     * 请注意一点，你返回的结果（包括index1和index2）都不是基于0开始的。你可以假设每一个输入肯定只有一个结果。
     * <p>
     * 解题思路
     * 创建一个辅助类数组，对辅助类进行排序，使用两个指针，开始时分别指向数组的两端，看这两个下标对应的值是否
     * 等于目标值，如果等于就从辅助类中找出记录的下标，构造好返回结果，返回。如果大于就让右边的下标向左移，
     * 进入下一次匹配，如果小于就让左边的下标向右移动，进入下一次匹配，直到所有的数据都处理完
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};

        NodeSum[] tmp = new NodeSum[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = new NodeSum(nums[i], i);
        }

        Arrays.sort(tmp);

        int lo = 0;
        int hi = nums.length - 1;


        while (lo < hi) {
            if (tmp[lo].val + tmp[hi].val == target) {

                if (tmp[lo].idx > tmp[hi].idx) {
                    result[0] = tmp[hi].idx + 1;
                    result[1] = tmp[lo].idx + 1;
                } else {
                    result[0] = tmp[lo].idx + 1;
                    result[1] = tmp[hi].idx + 1;
                }
                break;
            } else if (tmp[lo].val + tmp[hi].val > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return result;
    }
}
