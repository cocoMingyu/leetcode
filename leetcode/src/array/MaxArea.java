package array;

/**
 * @ Author : kn
 * @ Description :给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * @ Date : 2024/9/2 17:24
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int max = 0;
        for (int x = 0; x < height.length; x++) {
            int y = height[x];
            for (int x1 = x+1; x1 < height.length; x1++) {
                int y1 = height[x1];
                int num = Math.min(y, y1) * (x1 - x);
                max=Math.max(max, num);
            }
        }
        return max;
    }

    /**
     * 左右各一个指针，向中间移动，每次移动后计算当前面积，比较最大面积，每次移动指针时，比较当前高度，不动当前高的指针，移动矮的指针，直至两指针重合
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int max = 0;
        int l = 0;
        int r= height.length-1;
        while(l!=r){
            int num = (r - l) * Math.min(height[r], height[l]);
            max=Math.max(max, num);
            if (height[r] >= height[l]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {4,8,6,2,110,5,114,8,3,7};
        System.out.println(maxArea(height2));
    }
}
