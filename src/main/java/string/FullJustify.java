package string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Author : kn
 * @ Description : 68. 文本左右对齐
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 *
 * 示例 1:
 *
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * 提示:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 * @ Date : 2025/10/26 14:21
 */
public class FullJustify {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        List<String> row=new ArrayList<>();
        //行长度，包含空格
        int rowLength=maxWidth;
        //一行单词长度
        int rowWordLength=0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //单词占用长度
            int wordLength=row.size()==0?word.length():word.length()+1;
            if (wordLength<=rowLength){
                row.add(word);
                rowLength-=wordLength;
                rowWordLength+=word.length();
            }else {
                //组装行
                res.add(append(row,maxWidth,rowWordLength));
                rowLength=maxWidth-word.length();
                row.clear();
                row.add(word);
                rowWordLength=word.length();
            }
        }
        if (row.size()>0)
            res.add(append(row,maxWidth,rowWordLength));

        return res;
    }

    public static String append(List<String> words,int maxWidth,int rowWordLength){
        StringBuilder sb=new StringBuilder();
        //一个元素
        if (words.size()==1){
            sb.append(words.get(0));
            for (int i = 0; i < maxWidth-rowWordLength; i++) {
                 sb.append(" ");
            }
            return sb.toString();
        }

        //间隔几个空格
        int space = (maxWidth-rowWordLength)/(words.size()-1);
        //多余的空格
        int yu = (maxWidth-rowWordLength)%(words.size()-1);
        for (int i = 0; i < words.size()-1; i++) {
            sb.append(words.get(i));
            if (yu>0){
                sb.append(" ");
                yu--;
            }
            for (int j = 0; j < space; j++) {
                 sb.append(" ");
            }
        }
        return sb.append(words.get(words.size()-1)).toString();
    }

    public static void main(String[] args) {
        List<String> list = fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        list.forEach(v -> System.out.println("长度:"+v.length()+"\t"+v));

        List<String> list1 = fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        list1.forEach(v -> System.out.println("长度:"+v.length()+"\t"+v));

        List<String> list2 = fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
        list2.forEach(v -> System.out.println("长度:"+v.length()+"\t"+v));
    }
}
