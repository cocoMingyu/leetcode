package array;

import java.util.*;

/**
 * @ Author : kn
 * @ Description :  15. 三数之和
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        //排序，左右两边分别向中间移动
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //确定第一个数x ,求两数之和为-x
        for (int i = 0; i < nums.length; i++) {
            //第一个数字去重
            if (i>0&&nums[i-1]==nums[i]){
                continue;
            }
            //数组以排序，第一位大于0，后续不可能相加等于零
            if (nums[i]>0){
                break;
            }

            int l = i+1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum<0) {
                    l++;
                } else if (sum>0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //去重,控制不产生重复三元组，第一位数字确定nums[i]，nums[l]!=nums[l+1] 相等的话会产生重复数据
                    while (l<r&&nums[l]==nums[l+1]) l++;
                    while (l<r&&nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,1,1,-2}));
        System.out.println(threeSum(new int[]{-100, -70, -60, 110, 120, 130, 160}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
