package search;

/**
 * @ Author : kn
 * @ Description :35. 搜索插入位置
 * 简单
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 * @ Date : 2024/11/16 14:09
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        int index = left+((right - left) / 2);
        int num = nums[index];
        if (num==target){
            return index;
        }
        // 如果left+1=right，说明已经遍历完，没有找到答案.根据与左右边界大小对比，返回插入的位置
        if (right-left<=1){
            return target<nums[left]?left:target>nums[right]?right+1:right;
        }
        if (num > target) {
            return binarySearch(nums, target, left, index);
        }
        return binarySearch(nums,target,index,right);
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 33;
        int searchInsert = new SearchInsert().searchInsert(nums, target);
        System.out.println(searchInsert);
    }
}
