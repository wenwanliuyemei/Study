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


    /**
     * 题目大意：
     * 两个排序数组，找这两个排序数组的中位数，时间复杂度为O(log(m+n))
     * 题解思路：
     * 递归分治求解
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null) {
            nums1 = new int[0];
        }

        if (nums2 == null) {
            nums2 = new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 < len2) {
            // 确保第一个数组比第二个数组长度大
            return findMedianSortedArrays(nums2, nums1);
        }

        if(len1==0){
            return -1;
        }
        // 如果长度小的数组长度为0，就返回前一个数组的中位数
        if (len2 == 0) {
            return (nums1[(len1 - 1) / 2] + nums1[len1 / 2]) / 2.0;
        }


        int lo = 0;
        int hi = len2 * 2;
        int mid1;
        int mid2;
        double l1;
        double l2;
        double r1;
        double r2;

        while (lo <= hi) {
            mid2 = (lo + hi) / 2;
            mid1 = len1 + len2 - mid2;

            l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];

            r1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            r2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (l1 > r2) {
                lo = mid2 + 1;
            } else if (l2 > r1) {
                hi = mid2 - 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }

        return -1;
    }

}
