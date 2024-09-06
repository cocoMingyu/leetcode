package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author : kn
 * @ Description : 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @ Date : 2024/9/6 9:48
 */
public class MergeArea {
    public static int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][];
        //原始数组排序
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length-i-1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]){
                    int[] temp=intervals[j];
                    intervals[j]=intervals[j+1];
                    intervals[j+1]=temp;
                }
            }
        }
        int[] range = new int[2];
        for (int i = 0; i < intervals.length; i++) {
            boolean init = range[0] == 0 && range[1] == 0;
            if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
                //i区间第1个元素>=第2个区间第0个元素
                range[0] =init?intervals[i][0]:Math.min(intervals[i][0],range[0]);
                range[1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                if (init) {
                    res[i] = intervals[i];
                } else {
                    res[i] = range;
                }
                range = new int[2];
            }
        }
        return Arrays.stream(res).filter(x ->x!=null).toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,2},{3,5}};
        int[][] intervals2 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals3 = {{4,5},{1,4},{0,1}};
        int[][] intervals4 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = merge(intervals4);
        System.out.println(Arrays.toString(merge));
    }
}
