package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。

 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class subarraySum {
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                int num = nums[j];
                sum+=num;
                if (sum==k){
                    res++;
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,0};
        int k = 0;

        int[] nums1 = {-1,1,3,3,1,2,4,5,6,2,1};
        int k1 = 3;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum(nums1, k1));
    }
}
