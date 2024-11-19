package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ Author : kn
 * @ Description :20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([])"
 * 输出：true
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * @ Date : 2024/11/19 19:48
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 栈为空，直接入栈
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                // 栈不为空，判断栈顶元素是否与当前元素是否匹配，匹配则出栈，否则入栈
                char peek = stack.peek();
                if (map.get(peek)!=null&&map.get(peek).equals(c)){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(new IsValid().isValid("({([])})"));
        System.out.println(new IsValid().isValid("(]"));
    }
}
