package array;

import java.util.*;

/**
 * @ Author : kn
 * @ Description : 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * @ Date : 2024/8/31 14:36
 */
public class longestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int finalCount =1;
        int count = 1;
        for (int i = 0; i < nums.length-1; i++) {
            //两个数字相等跳过
            if (nums[i] == nums[i+1]){
                continue;
            }
            if (nums[i]+1 == nums[i+1]){
                count++;
            }else {
                if (finalCount == 1 || count > finalCount){
                    finalCount=count;
                }
                count=1;
            }
        }
        //循环到最后没有断，重新赋值
        return Math.max(count, finalCount);
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            set.add(num);
        }

        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //不是序列开头的数字跳过
            if (set.contains(num-1)){
                continue;
            }
            int currentNum=num;
            int currentLength =1;
            while (set.contains(currentNum+1)){
                currentNum++;
                currentLength++;
            }
            length=Math.max(length,currentLength);
        }
        return length;

    }

    public static void main(String[] args) {

        int i3 = longestConsecutive2(new int[]{1,2,0,1});
        System.out.println(i3);
    }
}
