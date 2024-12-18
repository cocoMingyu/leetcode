package algorithm.backtracking;

/**
 * @ Author : kn
 * @ Description :79. 单词搜索
 * 中等
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * @ Date : 2024/11/13 17:55
 */
public class Exists {
    //优化从后向前匹配
    public boolean exist(char[][] board, String word) {
        for (int k = 0; k < board.length; k++) {
            for (int j = 0; j < board[k].length; j++) {
                //找到匹配的首字母
                if (board[k][j] == word.charAt(word.length() - 1)) {
                    boolean dfs = dfs(board, word, k, j, 0, word.length() - 1);
                    if (dfs)
                        return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int deep, int end) {
        //不能超过边界
        if (row >= 0 && row < board.length && col >= 0 && col < board[row].length
                && board[row][col] == word.charAt(end)) {
            if (end == 0) {
                return true;
            }
            //找到目标字符，则返回true，并将当前节点置空，防止重复
            char c = board[row][col];
            board[row][col] = ' ';
            boolean match = dfs(board, word, row + 1, col, deep + 1, end - 1) ||
                    dfs(board, word, row - 1, col, deep + 1, end - 1) ||
                    dfs(board, word, row, col + 1, deep + 1, end - 1) ||
                    dfs(board, word, row, col - 1, deep + 1, end - 1);
            if (!match) {
                board[row][col] = c;
            }
            return match;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";

        Exists exists = new Exists();
        boolean b = exists.exist(board, word);
        System.out.println(b);
    }

}
