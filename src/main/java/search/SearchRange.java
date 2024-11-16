package search;

/**
 * @ Author : kn
 * @ Description :34. 在排序数组中查找元素的第一个和最后一个位置
 * 中等
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * @ Date : 2024/11/16 15:44
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-120, -120};
        if (nums.length > 0){
            binarySearch(nums, res, target, 0, nums.length - 1);
        }else {
            res[0]=-1;
            res[1]=-1;
        }
        return res;
    }

    public void binarySearch(int[] nums, int[] res, int target, int left, int right) {
        int index = left + ((right - left) / 2);
        int num = nums[index];

        if (right - left <= 1) {
            if (nums[left] == target){
                res[0] = nums[left] == target ? left : nums[right] == target ? right : -1;
            }
            if (nums[right] == target){
                res[1] = nums[right] == target ? right : nums[left] == target ? left : -1;
            }
            return;
        }

        if (num == target) {
            //判断左右两侧是否含有相同值，有的话继续搜索
            if (index - 1 >= 0 && nums[index - 1] == target) {
                binarySearch(nums, res, target, left, index - 1);
            } else {
                res[0] = index;
            }
            if (index + 1 <= nums.length - 1 && nums[index + 1] == target) {
                binarySearch(nums, res, target, index + 1, right);
            } else {
                res[1] = index;
            }
        }


        if (num > target) {
            binarySearch(nums, res, target, left, index);
        } else {
            binarySearch(nums, res, target, index, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,5,5};
        int target = 5;
        int[] ints = new SearchRange().searchRange(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
