package list;

import java.util.List;

/**
 * @ Author : kn
 * @ Description :两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * @ Date : 2024/9/11 17:17
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int gtTen = 0;
        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (l1 != null && l2 != null) {
            int sum = gtTen + l1.val + l2.val;
            gtTen = sum/10;
            ListNode listNode = new ListNode(sum%10);
            cur.next = listNode;
            cur = listNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        cur.next = l1 == null ? l2 : l1;
        while (cur.next != null) {
            int sum = gtTen + cur.next.val;
            gtTen = sum /10;
            cur.next.val = sum%10;
            cur=cur.next;
        }
        //如果最后还是大于10，进位，添加1节点
        if (gtTen>0) cur.next = new ListNode(gtTen);
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode listNode = addTwoNumbers(node1, node4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
