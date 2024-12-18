package array;

import java.util.*;

/**
 * @ Author : kn
 * @ Description : 347. 前 K 个高频元素
 * 中等
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]

 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * @ Date : 2024/12/18 16:10
 */
public class TopKFrequent {

    /**
     * 堆排序 PriorityQueue内部实现堆排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count=new HashMap<>();
        for (int i : nums) {
            Integer num = count.getOrDefault(i, 0);
            count.put(i,num+1);
        }
        //PriorityQueue 存储数组，0-数字 1-出现次数，按照数组的第二个元素进行排序
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) ->a[1]-b[1]);
        for (Map.Entry<Integer,Integer> entry : count.entrySet()) {
            priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});
            if (priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=priorityQueue.poll()[0];
        }
        return res;
    }

    /**
     * 桶排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        //统计每个数字出现的次数，k-数字，v-次数
        Map<Integer,Integer> count=new HashMap<>();
        for (int i : nums) {
            Integer num = count.getOrDefault(i, 0);
            count.put(i,num+1);
        }
        //下标是数字出现的次数，值是数字
        List<Integer>[] bucket=new List[nums.length+1];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (Integer key : count.keySet()) {
            max=Math.max(max,count.get(key));
            min=Math.min(min,count.get(key));
            List<Integer> list = bucket[count.get(key)];
            if (list==null){
                list=new ArrayList<>();
                bucket[count.get(key)]=list;
            }
            list.add(key);
        }

        int[] res=new int[k];
        for (int i = max; i >=min; i--) {
            if (bucket[i]!=null){
                List<Integer> list = bucket[i];
                for (Integer integer : list) {
                    res[--k]=integer;
                    if (k==0){
                        return res;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,5,3,5,3,1,1,3,5,4};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] res = topKFrequent.topKFrequent2(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
