package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : kn
 * @ Description :131. 分割回文串
 * 中等
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * @ Date : 2024/11/14 14:50
 */
public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, 0, new ArrayList<>(), result);
        return result;
    }


    /**
     * 递归
     *
     * @param s      字符串
     * @param start  字符串起始坐标
     * @param deep   递归深度
     * @param arr    回文串数组
     * @param result 结果集
     */
    public void dfs(String s, int start, int deep, List<String> arr, List<List<String>> result) {
        //递归边界 递归深度等于字符串长度，或者起始坐标大于字符串长度-1
        if (deep >= s.length() || start > s.length() - 1) {
            result.add(new ArrayList<>(arr));
            return;
        }
        for (int length = 1; length + start <= s.length(); length++) {
            //每次分割宽度依次递增
            String substring = s.substring(start, start + length);
            boolean palindrome = isPalindrome(substring);
            if (palindrome) {
                arr.add(substring);
                dfs(s, start + length, deep + 1, arr, result);
                arr.remove(arr.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabaa";
        List<List<String>> partition = new Partition().partition(s);
        System.out.println(partition);
    }
}
