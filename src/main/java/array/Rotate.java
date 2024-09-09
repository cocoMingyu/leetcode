package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author : kn
 * @ Description :189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * @ Date : 2024/9/7 14:41
 */
public class Rotate {
    public static void test(int[] nums, int k){
        if (nums.length<=1){
            return ;
        }
        int[] copy=new int[nums.length];
        System.arraycopy(nums,0,copy,0,nums.length);

        //k大于数组时，k等于数组长度的倍数等于回到起点，所以k=k % nums.length
        k = k >= nums.length ? k = k % nums.length : k;
        for (int i = 0; i < nums.length; i++) {
            if (i<k){
                nums[i]=copy[i+nums.length-k];
            }else {
                nums[i]=copy[i-k];
            }
        }
    }


    /**
     * 数组反转
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int[] nums2 = {-1,-100};
        int[] nums3 = {-1};
        int k = 3;
        test(nums2, k);
        test(nums3, k);
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}
