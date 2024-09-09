package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author : kn
 * @ Description :54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * @ Date : 2024/9/9 11:37
 */
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        //定义4个指针，分别表示上下左右边界
        int left = 0, right = matrix[0].length - 1;
        int bottom = matrix.length - 1, top = 0;

        //定义边界，循环多少次长方体边长
        while(true){
            //向右移动，这一行已经处理完，所以++top
            for (int i = left; i <=right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top>bottom) break;

            //向下移动，这一列已经处理完，所以--right
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (left>--right) break;

            //向左移动，这一行已经处理完，所以--bottom
            for (int i = right; i >=left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom<top) break;

            //向上移动，这一列已经处理完，所以++left
            for (int i = bottom; i >=top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left>right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}}));
/*        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));*/
    }
}
