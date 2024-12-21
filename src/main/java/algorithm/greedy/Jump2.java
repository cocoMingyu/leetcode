package algorithm.greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author : kn
 * @ Description :45. 跳跃游戏 II
 * 中等
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * 提示:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * @ Date : 2024/12/20 15:50
 * 2,7,3,1,1,4
 */
public class Jump2 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        //当前最远能够到达的位置
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            //更新最远能够到达的位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //如果到达当前最远位置步数加一，更新end
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        int[] nums2 = {2,3,1,1,4};
        Jump2 jump2 = new Jump2();
        System.out.println(jump2.jump(nums));
        System.out.println(jump2.jump(nums2));
    }
}
