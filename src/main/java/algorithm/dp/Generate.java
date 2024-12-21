package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : kn
 * @ Description :118. 杨辉三角
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 * @ Date : 2024/12/21 18:16
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> array = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(array.get(i - 1).get(j - 1) + array.get(i - 1).get(j));
                }
            }
            array.add(row);
        }
        return array;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        List<List<Integer>> lists = generate.generate(5);
        System.out.println(lists);
    }
}
