package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author : kn
 * @ Description : 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @ Date : 2024/9/12 11:47
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int count = 1;
        while (head != null) {
            nodeMap.put(count, head);
            head = head.next;
            count++;
        }
        int i = nodeMap.size() - n + 1;
        ListNode listNode = nodeMap.get(i - 1);
        //移除节点前面没有节点，说明头结点被移除了,直接返回后面的节点
        if (listNode==null){
            return nodeMap.get(i + 1);
        }
        listNode.next = nodeMap.get(i + 1);
        return nodeMap.get(1);
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        int count = 0;
        ListNode pre=head;
        while (pre != null) {
            pre = pre.next;
            count++;
        }
        //添加哑巴节点，不用考虑头结点是否移除的问题
        ListNode node = new ListNode(1,head);

        int num=1;
        pre=node;
        while (head!=null){
            if (num==count-n+1){
                pre.next=head.next;
                break;
            }
            pre=head;
            head=head.next;
            num++;
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
        ListNode node = removeNthFromEnd2(node1, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
