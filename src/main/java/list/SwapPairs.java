package list;

/**
 * @ Author : kn
 * @ Description : 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * @ Date : 2024/9/12 14:24
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0,head);
        ListNode fast = node;
        while (fast.next!=null&&fast.next.next!=null){
            ListNode first = fast.next;
            ListNode second = fast.next.next;
            first.next=second.next;
            second.next=first;
            fast.next=second;
            fast=first;
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
        ListNode node = swapPairs(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
