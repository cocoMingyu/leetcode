package graph;

import java.util.*;

/**
 * @ Author : kn
 * @ Description :207. 课程表
 * 中等
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 *
 * 提示：
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * @ Date : 2024/11/7 21:40
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接表
        List<List<Integer>> list = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        //入度数组
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            //对应索引位置，邻接表添加元素
            list.get(prerequisite[1]).add(prerequisite[0]);
            //对应索引位置 入度数+1
            inDegree[prerequisite[0]]++;
        }
        //入度队列，存放入度为0的课程,即没有依赖课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i]==0){
                queue.add(i);
            }
        }

        //入度数=0的课程数量，即完成课程数量
        int count=0;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            count++;
            for (Integer num : list.get(poll)) {
                //入度-1
                --inDegree[num];
                //入度为0，入队
                if (inDegree[num]==0){
                    queue.add(num);
                }
            }
        }
        //完成课程数量=课程总数，返回true
        return count==numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0,1}};
        int numCourses = 2;
        CanFinish canFinish = new CanFinish();

        boolean b = canFinish.canFinish(numCourses, prerequisites);
        System.out.println(b);
    }
}
