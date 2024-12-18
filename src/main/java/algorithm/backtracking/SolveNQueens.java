package algorithm.backtracking;

import java.util.*;

/**
 * @ Author : kn
 * @ Description :51. N 皇后
 * 困难
 * 相关标签
 * 相关企业
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * @ Date : 2024/11/15 18:26
 */
public class SolveNQueens {
    int[] arr;
    Set<Integer> cols=new HashSet<>();
    //左上到右下角行列下标之差相等
    Set<Integer> rightDowns=new HashSet<>();
    //左下到右上角行列下标之和相等
    Set<Integer> leftUps=new HashSet<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        arr=new int[n];
        dfs(0,n);

        return result;
    }

    public void dfs(int row, int n) {
        if (row==n){
            result.add(generate(arr));
            return;
        }
        for (int col = 0; col < n; col++) {
            //当前列不能与之前的皇后处于同一列
            if (cols.contains(col)){
                continue;
            }
            //左上到右下角行列下标之差相等
            int rightDown = row - col;
            if (rightDowns.contains(rightDown)){
                continue;
            }
            //左下到右上角行列下标之和相等
            int leftUp = row + col;
            if (leftUps.contains(leftUp)){
                continue;
            }
            arr[row]=col;
            cols.add(col);
            rightDowns.add(rightDown);
            leftUps.add(leftUp);
            dfs(row+1,n);
            cols.remove(col);
            rightDowns.remove(rightDown);
            leftUps.remove(leftUp);
            arr[row]=0;
        }
    }

    public static List<String> generate(int[] arr){
        List<String> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (j==arr[i]){
                    sb.append('Q');
                }else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }


    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        solveNQueens.solveNQueens(4);
        System.out.println(solveNQueens.result);
    }
}
