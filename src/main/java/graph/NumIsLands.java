package graph;

/**
 * @ Author : kn
 * @ Description :200. 岛屿数量
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * @ Date : 2024/11/7 13:04
 */
public class NumIsLands {
    /**
     *  1.每次遍历找到相邻岛屿标记为0，直到没有相邻岛屿，计数加一
     *  2.重复1的过程，直到全部遍历完
     */

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==(char) (1+'0')){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
        //不能超过边界
        if (i>=0&&i< grid.length&&j>=0&&j< grid[i].length){
            char element = grid[i][j];
            if (element==(char) (1+'0')){
                // 标记为0
                grid[i][j] = (char) ('0');
                //上下左右分别递归
                dfs(grid,i-1,j);
                dfs(grid, i+1, j);
                dfs(grid, i, j-1);
                dfs(grid, i, j+1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'1', '1', '0', '1', '1'}
        };


        NumIsLands numIsLands = new NumIsLands();
        int i = numIsLands.numIslands(grid2);
        System.out.println(i);
    }
}
