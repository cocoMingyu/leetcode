package search;

/**
 * @ Author : kn
 * @ Description :153. 寻找旋转排序数组中的最小值
 * 中等
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 3 次得到输入数组。
 * <p>
 * 示例 3：
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * @ Date : 2024/11/19 10:02
 */
public class FindMin {
    //时间复杂度O(n)
    public int findMin(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            //到最后一位全是正序，说明没有旋转，第一个元素就是最小的
            if (i == nums.length - 1) {
                return nums[0];
            }
            if (nums[i] >= nums[i + 1]) {
                k = i;
                break;
            }
        }
        return nums[k + 1];
    }

    public int findMin2(int[] nums) {
        //判断是否顺序，顺序直接返回第一个元素
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }

        //最小值一定在乱序一侧，以此来缩小搜索范围
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //中间值大于右边界，说明最小值在右边，左边界向右移动
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                //中间值<=右边界，说明最小值在左边，右边界向左移动，不需要mid-1
                right = mid ;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        int[] nums = {6, 7, 0, 1, 2, 4, 5};

        int[] nums2 = new int[]{17, 11, 13, 15};
        int[] nums3 = new int[]{3, 4, 5, 1, 2};
        int[] nums4 = new int[]{4,3};
        int[] nums5 = new int[]{3,4};
        int[] nums6 = new int[]{3};
        int[] nums7 = { 2, 4, 5,6, 7, 0, 1};
        System.out.println(new FindMin().findMin2(nums));
        System.out.println(new FindMin().findMin2(nums2));
        System.out.println(new FindMin().findMin2(nums3));
        System.out.println(new FindMin().findMin2(nums4));
        System.out.println(new FindMin().findMin2(nums5));
        System.out.println(new FindMin().findMin2(nums6));
        System.out.println(new FindMin().findMin2(nums7));
    }
}
