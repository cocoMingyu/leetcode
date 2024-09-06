package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author:kn
 * @ Description: 编写一个函数来查找字符串数组中的最长公共前缀,如果不存在公共前缀，返回空字符串 ""
 * @ Date:Created in 2019/2/15 18:26
 * @ Modified By:
 */
public class longestCommonPrefix {
    public String test(String[] strs) {
        List list=new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i].toCharArray());
        }
        for (int i = 0; i < list.size(); i++) {
            String str = strs[i];

        }
        String common="";
        return common;
    }

    public static void main(String[] args) {
        String[] str={"sadfasda","sds","sfdawr"};
        new longestCommonPrefix().test(str);
    }
}
