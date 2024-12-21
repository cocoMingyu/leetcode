package algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author : kn
 * @ Description :763. 划分字母区间
 * 中等
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 *
 * 示例 2：
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 仅由小写英文字母组成
 * @ Date : 2024/12/21 16:15
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        //收集字母的最后出现的位置
        int[] position= new int[26];
        for (int i = 0; i < s.length(); i++) {
            position[s.charAt(i)-'a']=i;
        }
        //片段的最远位置
        int segmentEnd=0;
        //片段的起始位置
        int segmentStart=0;
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
             //片段的字母到最远位置,不断更新最远位置
            char c = s.charAt(i);
            int lastIndex = position[c-'a'];
            segmentEnd=Math.max(segmentEnd,lastIndex);
            //到达片段的最远位置
            if (i==segmentEnd){
                res.add(segmentEnd-segmentStart+1);
                segmentStart=segmentEnd+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
