package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : kn
 * @ Description :22. 括号生成
 * 中等
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * @ Date : 2024/11/13 16:45
 */
public class GenerateParenthesis {
    int l = 0;

    public List<String> generateParenthesis(int n) {
        l = n;
        List<String> result = new ArrayList<>();
        dfs(result, new StringBuffer(), n, n);
        return result;
    }

    public void dfs(List<String> result, StringBuffer sb, int left, int right) {
        if (sb.length() == l * 2) {
            result.add(sb.toString());
        }

        if (left > 0) {
            //添加左括号
            dfs(result, sb.append("("), left-1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        //剪枝 左括号剩余数量小于右括号数量，说明有多余的左括号，才能添加右括号
        if (left<right&&right > 0) {
            //添加右括号
            dfs(result, sb.append(")"), left, right-1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParenthesis().generateParenthesis(0);
        System.out.println(result);
    }
}
