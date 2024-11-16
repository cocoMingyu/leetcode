package search;

/**
 * @ Author : kn
 * @ Description :74. 搜索二维矩阵
 * 中等
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。

 * 示例 1：

 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false

 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * @ Date : 2024/11/16 15:28
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            if (matrix[i][0] <= target && target <= matrix[i][ints.length-1]){
                return binarySearch(ints,target,0,ints.length-1);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target, int left, int right) {
        int index = left+((right - left) / 2);
        int num = nums[index];
        if (num==target){
            return true;
        }
        // 如果差值小于等于1，则直接判断是否相等
        if (right-left<=1){
            return nums[left]==target || nums[right]==target;
        }
        if (num > target) {
            return binarySearch(nums, target, left, index);
        }
        return binarySearch(nums,target,index,right);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3}};
        int target = 3;
        boolean searchMatrix = new SearchMatrix().searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
