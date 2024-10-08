package array;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 */
public class SearchMatrix {
    public static boolean test(int[][] matrix, int target) {
        // 定义横纵坐标,从右上角开始搜索,坐标值<target,clo++,坐标值>target,row--
        int row = 0, clo = matrix[0].length - 1;
        while (row < matrix.length && clo >= 0) {
            if (matrix[row][clo] == target) {
                return true;
            }

            if (matrix[row][clo] < target) {
                row++;
            } else {
                clo--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int[][] matrix2 = {{1, 1}};
        System.out.println(test(matrix2, 2));

        StringBuilder sb=new StringBuilder();
       
        sb.reverse().toString().equals(sb.toString());
    }
}
