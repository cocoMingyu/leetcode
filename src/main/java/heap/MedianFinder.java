package heap;

import java.util.PriorityQueue;

/**
 * @ Author : kn
 * @ Description :295. 数据流的中位数
 * 困难
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 *
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 *
 * 示例 1：
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 *
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * 提示:
 *
 * -105 <= num <= 105
 * 在调用 findMedian 之前，数据结构中至少有一个元素
 * 最多 5 * 104 次调用 addNum 和 findMedian
 * @ Date : 2024/12/18 19:51
 */
public class MedianFinder {
    //小根堆 存储中位数右边部分
    PriorityQueue<Integer> minQueue;
    //大根堆 存储中位数左边部分
    PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        //新加元素小于中位数，放入左边
        if (maxQueue.isEmpty()||maxQueue.peek()>num){
            maxQueue.offer(num);
            //左边元素大于右边元素，调整.将大根堆最大的元素放入小根堆
            if (maxQueue.size()-1>minQueue.size()){
                minQueue.offer(maxQueue.poll());
            }
        }else {
            minQueue.offer(num);
            //右边元素大于左边元素，调整.将小根堆最小的元素放入大根堆
            if (minQueue.size()>maxQueue.size()){
                maxQueue.offer(minQueue.poll());
            }
        }
    }

    public double findMedian() {
        double res=0;
        //奇数个元素，取大根堆的堆顶元素
        if ((maxQueue.size()+minQueue.size())%2==1){
            res= maxQueue.peek();
        }
        // 偶数个元素，取中位数
        else {
            res=(maxQueue.peek()+minQueue.peek())/2.0;
        }
        return res;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        medianFinder.addNum(14);
        medianFinder.addNum(15);
        medianFinder.addNum(16);
        medianFinder.addNum(17);
        System.out.println(medianFinder.findMedian());
    }
}
