package array;

import java.util.Arrays;

/**
 * @ Author : kn
 * @ Description :  135. 分发糖果
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子中，评分更高的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 *
 * 提示：
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 * @ Date : 2025/10/23 20:29
 */
public class Candy {
    public static int candy(int[] ratings) {
        int length = ratings.length;
        if (length==0) return 0;

        int[] arr = new int[length];
        //每个人都有一个糖果，初始数组均为一
        Arrays.fill(arr,1);
        //从左向右遍历，i>i-1 加一个糖果
        for (int i = 1; i < length; i++) {
            if (ratings[i]>ratings[i-1]){
                arr[i]=arr[i-1]+1;
            }
        }

        //total从最后一个元素开始
        int total=arr[length-1];
        //从右向左遍历,i>i+1 加一个糖果，与arr数组元素对比取最大值
        for (int i = length-2; i >=0; i--) {
            if (ratings[i]>ratings[i+1]){
                arr[i]=Math.max(arr[i],arr[i+1]+1);
            }
            total+=arr[i];
        }
        return total;
    }

    public static void main(String[] args) {
        //1,2,3,4,1=11
        System.out.println(candy(new int[]{1,3,4,5,2}));
        //1,2,3,3,2,1=12
        System.out.println(candy(new int[]{29,51,87,87,72,12}));
        //1,3,2,2,1=9
        System.out.println(candy(new int[]{1,3,2,2,1}));
        //2,1,2=5
        System.out.println(candy(new int[]{1,0,2}));
        //1,2,1=4
        System.out.println(candy(new int[]{1,2,2}));
    }
}
