package string;

/**
 * @ Author : kn
 * @ Description :  125. 验证回文串
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 * @ Date : 2025/10/28 9:57
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        //左右指针比较有效字符是否相等
        int left=0,right=s.length()-1;
        while (left<right){
            if (!validStr(s.charAt(left))){
                left++;
            } else if (!validStr(s.charAt(right))) {
                right--;
            } else if (convert(s.charAt(left))!=convert(s.charAt(right))) {
                return false;
            } else if (convert(s.charAt(left))==convert(s.charAt(right))) {
                left++;
                right--;
            }
        }
        return true;
    }

    public static boolean validStr(char c){
        return (c>='0'&&c<='9')||(c>='A'&&c<='Z')||(c>='a'&&c<='z');
    }

    public static char convert(char c){
        if (c>='A'&&c<='Z'){
            return (char)(c+32);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(""));
    }
}
