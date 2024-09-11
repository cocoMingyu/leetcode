package list;

/**
 * @ Author : kn
 * @ Description :21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * @ Date : 2024/9/11 15:30
 */
public class MergeNode {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return list1;

        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (true) {
            if (list1 == null && list2 == null) {
                break;
            }
            //1节点值小于2节点，推进list1
            if ((list1 != null && list2 == null) || (list1 != null && list1.val < list2.val)) {
                ListNode listNode = new ListNode(list1.val);
                cur.next = listNode;
                cur = listNode;
                list1 = list1.next;
            }

            //1节点》=2节点，推进2节点
            if ((list2 != null && list1 == null) || (list2 != null && list1.val >= list2.val)) {
                ListNode listNode = new ListNode(list2.val);
                cur.next = listNode;
                cur = listNode;
                list2 = list2.next;
            }
        }
        return node.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return list1;

        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (list1 != null && list2 != null) {
            //1节点值小于2节点，推进list1
            //1节点》=2节点，推进2节点
            if (list1.val < list2.val) {
                cur.next=list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur=cur.next;
        }
        //循环到最后，一条小的链表循环完=null，直接把剩下的链表拼上就好
        cur.next=list1==null?list2:list1;
        return node.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;
        ListNode listNode = mergeTwoLists(node1, node4);
        while (listNode.next != null) {
            System.out.println(listNode.val);
        }
    }
}
