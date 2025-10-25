package string;

/**
 * @ Author : kn
 * @ Description :  58. 最后一个单词的长度
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为 5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为 4。
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为 6 的“joyboy”。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * @ Date : 2025/10/25 14:02
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] split = s.split("\\s+");
        return split[split.length-1].length();
    }

    public static int lengthOfLastWord2(String s) {
        int length=0;
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i)==' '){
                if (length>0){
                    break;
                }
            }else {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("Hello World"));
        System.out.println(lengthOfLastWord2("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord2("Today is a nice day"));
    }
}
