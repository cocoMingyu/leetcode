package string;

/**
 * @ Author : kn
 * @ Description :  14. 最长公共前缀
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 如果非空，则仅由小写英文字母组成
 * @ Date : 2025/10/25 14:49
 */
public class LongCommonString {
    public static String longestCommonPrefix(String[] strs) {
        int minLength=Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength=Math.min(minLength,strs[i].length());
        }

        StringBuilder sb=new StringBuilder();
        point:
        for (int i = 0; i < minLength; i++) {
            char last = strs[0].charAt(i);
            boolean eq=true;
            for (int j = 1; j < strs.length; j++) {
                if (last!=strs[j].charAt(i)){
                    eq=false;
                    break point;
                }
            }
            if (eq)
                sb.append(last);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cir","car"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }
}
