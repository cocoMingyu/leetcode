package array;

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
        if (ratings.length==1){
            return 1;
        }
        int min=Integer.MAX_VALUE;int minIndex=0;
        for (int i = 0; i < ratings.length; i++) {
            int rating = ratings[i];
            if (rating<min){
                min=rating;
                minIndex=i;
            }
        }
        int right=1,currentRate=1;
        for (int i = minIndex+1; i < ratings.length; i++) {
            int cha = ratings[i] - ratings[i - 1];
            if (cha>0){
                currentRate=currentRate+1;
            } else if (cha<0) {
                currentRate=currentRate-1<2?1:currentRate-1;
            }
            right+=currentRate;
        }

        int left=1,leftCurrentRate=1;
        for (int i = minIndex-1; i >=0; i++) {
            int cha = ratings[i] - ratings[i - 1];
            if (cha>0){
                leftCurrentRate=leftCurrentRate+1;
            } else if (cha<0) {
                leftCurrentRate=leftCurrentRate-1<2?1:leftCurrentRate-1;
            }
            left+=leftCurrentRate;
        }
        return left+right;
    }
}
