package array;

import java.util.*;

/**
 * 和为k的数组的个数
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

    /**
     * 计算0-i的前缀和prefixTotal，prefixTotal作为key，存入map，值为出现次数。
     * prefixTotal-k的值存在于map，说明之前的某个位置到i下标的前缀和等于k，说明有k的子数组，结果+该值的次数。
    */
    public static int subarraySum2(int[] nums, int k) {
        int res = 0;
        Map<Integer,Integer> totalCount =new HashMap<>();
        int prefixTotal=0;
        //特殊处理 从数组开始位置到某个位置的子数组和为k的情况（尤其k=0），这时前缀和还没有放入map中，所以提前初始化
        totalCount.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            prefixTotal+=num;

            Integer exist = totalCount.get(prefixTotal-k);
            if (exist!=null){
                res+=exist;
            }
            totalCount.put(prefixTotal,totalCount.getOrDefault(prefixTotal,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        int k = 0;

        int[] nums1 = {-1,1,3,3,1,2,-3,4,5,6,2,1};
        int k1 = 3;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum2(nums, k));
        System.out.println(subarraySum(nums1, k1));
        System.out.println(subarraySum2(nums1, k1));
    }
}
