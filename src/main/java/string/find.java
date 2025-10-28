package string;

/**
 * @ Author : kn
 * @ Description :  28. 找出字符串中第一个匹配项的下标
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * @ Date : 2025/10/26 13:37
 */
public class find {
    public static int strStr(String haystack, String needle) {
        if (needle.length()>haystack.length()){
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            //剩余字符串长度不足，退出
            if (haystack.length()-i<needle.length()){
                return -1;
            }
            boolean include=true;
            for (int j = 0; j < needle.length(); j++) {
                 if (haystack.charAt(i+j)!=needle.charAt(j)){
                     include=false;
                     break;
                 }
            }

            if (include)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }
}
