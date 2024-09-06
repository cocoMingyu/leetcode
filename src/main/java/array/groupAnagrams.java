package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ Author : kn
 * @ Description : 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * @ Date : 2024/8/31 11:21
 */
public class groupAnagrams {
    /**
     * 由相同的字母构成的单词，排序后的字符串是一致的，以此为key，相同的分为一组
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strIndexMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = strIndexMap.computeIfAbsent(key, v -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(strIndexMap.values());
    }

    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(lists);
    }
}
