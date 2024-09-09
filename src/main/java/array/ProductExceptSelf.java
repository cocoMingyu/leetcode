package array;

import java.util.Arrays;

/**
 * @ Author : kn
 * @ Description :238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * @ Date : 2024/9/7 15:24
 */
public class ProductExceptSelf {
    /**
     * 先求出数组的非0乘积，0的个数。每个索引只需用乘积除以该索引的值，即可得到结果。
     * 需要注意如果含有0，则除了0之外其他元素乘积为0。多个0则所有结果都是0
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int r=1;
        int hasZero=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                r=r*nums[i];
            }else {
                hasZero++;
            }
        }

        int[] result=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num==0){
                result[i]=hasZero<2?r:0;
            }else{
                result[i]=hasZero>0?0:r/num;
            }
        }
        return result;
    }

    /**
     * 使用结果数组存储左侧数组乘积
     * @param nums
     * @return
     */
    public static int[] productExceptSelf2(int[] nums) {
        int[] leftArr=new int[nums.length];
        //左边第一位没有乘积，=1
        leftArr[0]=1;
        for (int i = 1; i < nums.length; i++) {
            leftArr[i]=leftArr[i-1]*nums[i-1];
        }

        //左边乘积已经计算好，计算右侧乘积，right=右侧乘积
        int right=1;
        for (int i = nums.length-1; i >=0; i--) {
            leftArr[i]=leftArr[i]*right;
            right=right*nums[i];
        }
        return leftArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 0, 2, 3, 57, 8})));
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{0, 0, 2, 3, 57, 8})));
    }
}
