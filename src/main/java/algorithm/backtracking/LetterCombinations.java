package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : kn
 * @ Description :17. 电话号码的字母组合
 * 中等
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * @ Date : 2024/11/13 9:51
 */
public class LetterCombinations {
    String[][] arr = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), result);
        return result;
    }


    /**
     * 每次递归处理一个按键对应的数字，拼接上一次的结果
     * @param digits
     * @param index
     * @param sb
     * @param result
     */
    public void dfs(String digits, int index, StringBuilder sb, List<String> result) {
        //index与数字长度一致，说明已经处于递归的最深层，可以添加结果
        if (index == digits.length()) {
            if (sb.length()!=0)
                result.add(sb.toString());
            return;
        }
        //数字对应的字母数组
        String[] str = arr[Integer.parseInt(digits.substring(index, index + 1)) - 2];
        for (int j = 0; j < str.length; j++) {
            String s = str[j];
            sb.append(s);
            dfs(digits, index + 1, sb, result);
            //重置结果，让上一次的递归结果不影响下一次
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinations().letterCombinations("234");
        System.out.println(strings);
    }
}
