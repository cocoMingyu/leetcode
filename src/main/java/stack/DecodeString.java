package stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ Author : kn
 * @ Description :394. 字符串解码
 * 中等
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * 提示：
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 * @ Date : 2024/11/20 19:28
 */
public class DecodeString {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                //这里res是从[开始到]之间的字符串,倍数数组获取最后一个倍数，拼接字符串
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                //从字符串数组取出最后一个，拼接到倍数字符串。即[]外的字符串+倍数字符串 a2[c]
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9'){
                //如果是数字，按照十进制累加
                multi = multi * 10 + Integer.parseInt(c + "");
            } else{
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

        DecodeString decodeString = new DecodeString();
        //System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        //System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
