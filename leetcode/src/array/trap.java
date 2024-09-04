package array;

/**
 * @ Author : kn
 * @ Description :给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * @ Date : 2024/9/3 20:11
 */
public class trap {

    public static int trap(int[] height) {
        int resulrt = 0,left=0,right=height.length-1;
        int leftMax=0,rightMax=0;
        while (left<right){
            if (height[left]<height[right]){
                leftMax=Math.max(leftMax,height[left]);
                if (leftMax>height[left]){
                    resulrt+=leftMax-height[left];
                }
                left++;
            }
            if (height[left]>=height[right]){
                rightMax=Math.max(rightMax,height[right]);
                if (rightMax>height[right]){
                    resulrt+=rightMax-height[right];
                }
                right--;
            }
        }
        return resulrt;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
