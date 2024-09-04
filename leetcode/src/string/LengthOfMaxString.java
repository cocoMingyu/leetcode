package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ Author : kn
 * @ Description : 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @ Date : 2024/9/4 9:47
 */
public class LengthOfMaxString {
    public static int test(String s) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.length()-i<result){
                break;
            }
            for (int j = i; j < s.length(); j++) {
                String currentStr=String.valueOf(s.charAt(j));
                //重复
                if (map.containsKey(currentStr)){
                    map.clear();
                    result=Math.max(result,j-i);
                    break;
                }else {
                    map.put(currentStr,j);
                    if (j==s.length()-1){
                        result=Math.max(result,j-i+1);
                    }
                }
            }

        }
        return result;
    }

    public static int test2(String s) {
        Set<Character> set = new HashSet<>();
        int res=0,right=-1;
        for (int i = 0; i < s.length(); i++) {
            //左指针到数组边界无法构成大于res的子串，退出循环
            if (s.length()-i<res){
                break;
            }
            //左指针移动，set集合移除上一格左指针
            if (i>0){
                set.remove(s.charAt(i-1));
            }
            //右指针移动，如果右指针指向的字符不在set集合中，则将右指针指向的字符加入set集合
            while (right+1<s.length()&&!set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            res=Math.max(res,right-i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(test2("abcabcbb"));
        System.out.println(test2("dedf"));
        System.out.println(test2("pwwkew"));
    }
}
