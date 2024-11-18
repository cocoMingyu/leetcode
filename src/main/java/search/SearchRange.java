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
        int[] res = new int[]{-1,-1};
        int left = binarySearch(nums, target);
        if (left>=nums.length || nums[left]!=target){
            return res;
        }
        res[0] = left;
        //目标值+1，该值得左边界-1就是target的右边界
        res[1]= binarySearch(nums,target+1)-1;
        return res;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int index = left+((right-left)/2);
            //当前节点大于目标值，右边界向左移动
            if (nums[index]>=target){
                right=index-1;
            }else {
                //当前节点小于目标值，左边界向右移动
                left=index+1;
            }
        }
        //跳出循环时 left=right+1，nums[left]=nums[right+1]>=target
        //left是第一个》=target的元素，返回left
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4};
        int target = 4;
        int[] ints = new SearchRange().searchRange(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
