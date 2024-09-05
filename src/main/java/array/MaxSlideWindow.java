package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @ Author : kn
 * @ Description :239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * @ Date : 2024/9/5 17:12
 */
public class MaxSlideWindow {
    public static int[] test(int[] nums, int k) {
        int length = nums.length - k + 1;
        int[] result = new int[length];
        Deque<Integer> deque = new ArrayDeque<>();
        //记录窗口数据，移动时去掉第一个元素，右指针移动，添加新的元素，只需比较新元素和上一个窗口的最大值，不需要遍历整个窗口数据
        for (int i = 0; i < length; i++) {
            int r = i;
            if (r > 0) {
                deque.remove(nums[i - 1]);
                r = i + k - 1;
            }
            while (r < i + k && r < nums.length) {
                if (deque.isEmpty() || nums[r] >= deque.peekLast()){
                    deque.offerLast(nums[r]);
                }
                r++;
            }
            result[i] = maxHeap.peek();
        }
        return result;
    }


    public static int[] test2(int[] nums, int k) {
        int length = nums.length - k + 1;
        int[] result = new int[length];
        Integer max = null;
        //记录窗口数据，移动时去掉第一个元素，右指针移动，添加新的元素，只需比较新元素和上一个窗口的最大值，不需要遍历整个窗口数据
        for (int i = 0; i < length; i++) {
            int r = i;
            if (r > 0) {
                r = i + k - 1;
                //窗口右移，如果上一个元素是最大值，重置最大值，重新遍历整个窗口数据
                if (nums[i - 1] == max) {
                    max = null;
                    r = i;
                }
            }
            while (r < i + k && r < nums.length) {
                max = max == null ? nums[r] : Math.max(max, nums[r]);
                r++;
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 2};
        int[] result = test(nums, 2);
        System.out.println(Arrays.toString(result));
    }
}
