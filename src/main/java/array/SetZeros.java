package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 73. 矩阵置零
 * 中等
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class SetZeros {

    public static void test(int[][] matrix) {
        //k-列 v-行
        Map<Integer,Integer> columnMap = new HashMap<>();
        Map<Integer,Integer> rowMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 0) {
                    columnMap.put(j,i);
                    rowMap.put(i,j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            boolean rowZero = rowMap.containsKey(i);
            for (int j = 0; j < ints.length; j++) {
                //当前列存在0
                if (columnMap.containsKey(j)) {
                    ints[j] = 0;
                }
                //当前行存在0
                if (rowZero){
                    ints[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        int[][] ints1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        test(ints);
        //test(ints1);
        System.out.println(Arrays.deepToString(ints));
        System.out.println(Arrays.deepToString(ints1));
    }
}
