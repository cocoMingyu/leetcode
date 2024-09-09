package array;

import java.util.*;

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
        if (intervals.length<1){
            return new int[0][];
        }
        //原始数组排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left=intervals[i][0];
            int right=intervals[i][1];
            //区间的最大值小于下一个区间的最小值，表示两者不重叠，添加区间。i=0 初始化添加区间
            if(i==0||res.get(res.size()-1)[1]<left){
                res.add(new int[]{left,right});
            }else {
                //重叠区间,更新区间右边界
                res.get(res.size()-1)[1]=Math.max(right,res.get(res.size()-1)[1]);
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,2},{3,5}};
        int[][] intervals2 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals3 = {{4,5},{1,4},{0,1}};
        int[][] intervals4 = {{1,10},{2,3},{4,5},{6,7},{8,9}};

        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(merge(intervals2)));
        System.out.println(Arrays.deepToString(merge(intervals3)));
        System.out.println(Arrays.deepToString(merge(intervals4)));

    }
}
