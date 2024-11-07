package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @ Author : kn
 * @ Description :994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * <p>
 * 示例 3：
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 * @ Date : 2024/11/7 15:21
 */
public class OrangesRotting {
    int row=0;
    int col=0;
    /**
     * 使用队列，广度遍历
     * @param grid
     * @return
     */
    public int orangesRotting2(int[][] grid) {
        //分钟数，循环次数
        int bulk=0;
        //新鲜橘子个数
        int orange=0;
        //腐烂橘子队列
        Queue<int[]> queue=new LinkedList<>();
        row=grid.length;
        col=grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    orange++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()){
            int size=queue.size();
            boolean flag=false;
            //上下左右四个方向,等于1，该坐标改为腐烂，并把新鲜橘子减一，加入队列，继续遍历
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];

                if (include(i+1,j)&&grid[i+1][j]==1){
                    grid[i+1][j]=2;
                    orange--;
                    queue.add(new int[]{i+1,j});
                    flag=true;
                }
                if (include(i-1,j)&&grid[i-1][j]==1){
                    grid[i-1][j]=2;
                    orange--;
                    queue.add(new int[]{i-1,j});
                    flag=true;
                }
                if (include(i,j+1)&&grid[i][j+1]==1){
                    grid[i][j+1]=2;
                    orange--;
                    queue.add(new int[]{i,j+1});
                    flag=true;
                }
                if (include(i,j-1)&&grid[i][j-1]==1){
                    grid[i][j-1]=2;
                    orange--;
                    queue.add(new int[]{i,j-1});
                    flag=true;
                }
            }
            if (flag)bulk++;
        }

        //如果还有新鲜橘子，返回-1
        if (orange>0){
            return -1;
        }
        return bulk;
    }

    public boolean include(int i, int j){
        return i>=0&&i<row&&j>=0&&j<col;
    }



    private Set<String> set = new HashSet<>();

    public int orangesRotting(int[][] grid) {

        /**
         * 先找到全部腐烂橘子，一次遍历周围的新鲜橘子，把新鲜橘子变为腐烂橘子
         * 重复这一过程，直到全部腐烂橘子被遍历完，返回分钟数。
         */
        int count = 0;
        while (true) {
            //是否有新的腐烂橘子
            boolean exist = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2 && !set.contains(i + "," + j)) {
                        boolean dfs = dfs(grid, i, j, 0);
                        if (dfs) exist = true;
                    }
                }
            }
            //每次循环重置位置数组
            set.clear();
            if (exist) {
                count++;
            } else {
                break;
            }
        }

        //最后还有新鲜橘子，返回-1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int i, int j, int nearEle) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            // 判断是否为新鲜橘子，如果是，则变为腐烂橘子，并继续遍历周围的新鲜橘子
            int ele = grid[i][j];
            if (ele == 1) {
                grid[i][j] = 2;
                // 记录已经遍历过的位置，防止外层方法重复遍历
                set.add(i + "," + j);
                return true;
                //上一个节点不能是2，防止死循环
            } else if (ele == 2 && nearEle != 2) {
                boolean up = dfs(grid, i + 1, j, ele);
                boolean down = dfs(grid, i - 1, j, ele);
                boolean right = dfs(grid, i, j + 1, ele);
                boolean left = dfs(grid, i, j - 1, ele);
                return up || down || right || left;
            }
        }
        return false;
    }

    /**
     * [[2,1,1],[0,1,1],[1,0,1]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {0, 0, 1}
        };
        int i = new OrangesRotting().orangesRotting2(grid);
        System.out.println(i);
    }
}
