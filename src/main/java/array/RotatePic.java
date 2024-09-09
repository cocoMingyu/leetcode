package array;

import java.util.Arrays;

/**
 * @ Author : kn
 * @ Description : 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：

 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * @ Date : 2024/9/9 17:15
 */
public class RotatePic {
    public static void test(int[][] matrix){
        int n=matrix.length;
        //根据规律总计公式 f(x)(y)=f(y)(n-x-1)
        //每个数字需要旋转1次，才能到达正确位置,共有4角，需要置换4次才能全部旋转成功
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                //第一个数
                int first = matrix[i][j];
                //第二个数
                int second=matrix[j][n-i-1];
                //第三个数
                int three=matrix[n-i-1][n-j-1];
                //第四个数
                int four=matrix[n-j-1][i];
                //第四个数=three
                matrix[n-j-1][i]=three;
                matrix[n-i-1][n-j-1]=second;
                matrix[j][n-i-1]=first;
                matrix[i][j]=four;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        test(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
