package string;

import javafx.util.Pair;

import java.util.*;

/**
 * @ Author : kn
 * @ Description :给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * @ Date : 2024/9/4 16:00
 */
public class FindStr {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        //异构词每个字母出现次数
        Map<Character, Integer> word = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Integer num = word.get(p.charAt(i));
            if (num == null) {
                word.put(p.charAt(i), 1);
            } else {
                num++;
                word.put(p.charAt(i), num);
            }
        }

        Map<Character, Integer> match = new HashMap<>();

        //每次向右移动，添加一个新元素
        for (int i = 0; i < s.length(); i++) {
            int right = 0;
            //移除最左边的元素
            if (i > 0) {
                Integer num = match.get(s.charAt(i - 1));
                num--;
                if (num == 0) {
                    match.remove(s.charAt(i - 1));
                } else {
                    match.put(s.charAt(i - 1), num);
                }
                right = i + p.length() - 1;
            }

            while (right < i + p.length() && right < s.length()) {
                Integer num = match.get(s.charAt(right));
                if (num == null) {
                    match.put(s.charAt(right), 1);
                } else {
                    num++;
                    match.put(s.charAt(right), num);
                }
                right++;
            }

            boolean flag = match.keySet().size() == word.keySet().size();
            if (flag) {
                for (Character k : word.keySet()) {
                    Integer v = match.get(k);
                    if (v == null || !v.equals(word.get(k))) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        //异构词统计出现次数
        int[] word = new int[26];
        for (int i = 0; i < p.length(); i++) {
            word[p.charAt(i) - 'a']++;
        }

        //滑动窗口宽度固定，第一次读取p.length长度的字符，后面右指针移动，每次添加一个元素，同时移除上一个窗口的末尾元素
        int[] match = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int right = 0;
            if (i>0){
                right=i+p.length()-1;
                match[s.charAt(i-1)-'a']--;
            }

            //右指针小于窗口边界，字符串边界
            while (right<i+p.length()&&right < s.length()) {
                match[s.charAt(right)-'a']++;
                right++;
            }

            //比较数组
            if (Arrays.equals(word,match)){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams2(s, p));
    }
}
