package array;

/**
 * @ Author : kn
 * @ Description :  11. 盛最多水的容器
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 *
 * 提示：
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int area=0;
        //左右指针同时向中间移动，比较指针高度，短的指针移动
        int l=0,r=height.length-1;
        while (l<r){
            area=Math.max(area,(r-l)*Math.min(height[l],height[r]));
            if (height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return area;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {4,8,6,2,110,5,114,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea(height2));
    }
}
