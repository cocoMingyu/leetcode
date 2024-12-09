package array;

import java.util.Arrays;

/**
 * @ Author : kn
 * @ Description :215. 数组中的第K个最大元素
 * 中等
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * @ Date : 2024/11/26 19:26
 */
public class FindKthLargest {

    public int findKthLargest2(int[] nums, int k) {
        int[] arr = new int[20001];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            //nums数组的值范围【-10000, 10000】，值+10000作为arr下标，存储这个数字出现几次
            arr[nums[i] + 10000]++;
        }

        int res = 0;
        //从大到小遍历，找到第k大的值，k减去下标数字的次数
        for (int i = max + 10000; i >= 0; i--) {
            if (k <= arr[i]) {
                res = i - 10000;
                break;
            }
            k -= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest2(nums, k));
    }
}
