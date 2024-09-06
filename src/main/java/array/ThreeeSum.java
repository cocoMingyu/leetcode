package array;

import java.util.*;

/**
 * @ Author : kn
 * @ Description :
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
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
 * @ Date : 2024/9/2 19:01
 */
public class ThreeeSum {

    /**
     * 经过从小到大排序后，第一层循环确定第一个数x，要想三数之和=0，第一个数必是<=0，y,z数之和必>=0。
     * 第二层循环确定 y+z=-x，使用双指针。2,3数之和必>=0。那么指针相加<x，则左指针右移(两数之和变大)，>x，则右指针左移（两数之和变小）。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //第一个数必是<=0
            int one = nums[i];
            if (one > 0){
                break;
            }
            //跳过重复
            if (i>0&&one==nums[i-1]){
                continue;
            }

            int r= nums.length-1;
            //2,3数之和必>=0，
            for (int l = i+1; l < nums.length; l++) {
                //和上一次数字不能重复
                 if (l>i+1 && nums[l]==nums[l-1]){
                     continue;
                 }
                 //l 在 r的左边，两数之和大于-x，右指针左移
                 while (l < r&& nums[l] + nums[r] > -one){
                     r--;
                 }
                 //两个指针重合，则退出循环
                 if (l==r){
                     break;
                 }
                 if (nums[l]+nums[r]==-one){
                     res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                 }
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 确定第一个数x ,求两数之和为-x,
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(ints));
    }
}
