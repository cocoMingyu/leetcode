package array;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组
 * 是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * -2 -1 -4 0 -1 1 2 -3 1
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class maxSubArray {
    public static int maxSubArray(int[] nums) {
        int preSum=0;int maxSum=nums[0];
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            preSum=Math.max(preSum,nums[i]);
            maxSum=Math.max(maxSum,preSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,-1,-3,-1}));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-1,-3,-2}));
        System.out.println(maxSubArray(new int[]{-2,1}));
        System.out.println(maxSubArray(new int[]{1,-2,-1}));
    }
}
