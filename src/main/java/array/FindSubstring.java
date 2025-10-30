package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author : kn
 * @ Description :  30. 串联所有单词的子串
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * 示例 2：
 *
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * 示例 3：
 *
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 和 s 由小写英文字母组成
 * @ Date : 2025/10/30 15:50
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        //统计单词出现次数
        Map<String,Integer> dataMap=new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer v = dataMap.getOrDefault(words[i],0);
            dataMap.put(words[i], ++v);
        }
        //长度为subLength的一个个窗口
        int wordL = words[0].length();
        int subLength= wordL * words.length;
        for (int i = 0; i < words.length; i++) {
            if (words.length-i<subLength){
                break;
            }
            Map<String,Integer> curMap=new HashMap<>();
            boolean include=true;
            for (int j = 0; j < words.length; j++) {
                String v = s.substring(i + (j * wordL), i + (j * wordL) + wordL);
                Integer value = curMap.getOrDefault(v, 0);
                curMap.put(v, ++value);
                if (!dataMap.containsKey(v)||dataMap.get(v)<curMap.get(v)){
                    include=false;
                    break;
                }
            }
            if (include){
                res.add(i);
            }
        }
        return res;
    }
}
