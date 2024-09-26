package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : kn
 * @ Description :25. K 个一组翻转链表
 * 困难
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 1,2,3,4,5,6,7,8,9,0   3
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000

 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * @ Date : 2024/9/12 16:29
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(1, head);
        List<ListNode> list=new ArrayList<>();
        //取出全部节点
        while (head!=null){
            list.add(head);
            head=head.next;
        }

        //需要循环几次区间
        int count = list.size() / k;
        for (int j = 0; j < count; j++) {
            //区间左右索引
            int left=j*k,right=left+k;
            //区间内反转，只需要循环1/2次
            for (int i = 0; i < k/2; i++) {
                int reverseIndex=right-1-i;
                ListNode lastNode = list.get(left+i);
                list.set(left+i,list.get(reverseIndex));
                list.set(reverseIndex,lastNode);
            }
        }

        ListNode pre=node;
        for (int i = 0; i < list.size(); i++) {
            pre.next=list.get(i);
            pre=pre.next;
        }
        pre.next=null;
        return node.next;
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        int count=0;
        ListNode node=new ListNode(1);
        ListNode pre=null;
        ListNode cur=head;
        while (head!=null){
            //反转pre节点
            if (count==k){
                count=0;
                pre=null;
            }else {
                cur.next=pre;
                pre=cur;
                cur=head;
            }
            head=head.next;
            count++;

        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode node = reverseKGroup2(node1,3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
