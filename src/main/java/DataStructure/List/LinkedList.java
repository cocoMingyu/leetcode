package DataStructure.List;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/2/19 16:04
 * @ Modified By:
 */
public class LinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        //建立一个新的链表用于存储
        ListNode root = new ListNode();
        root.next = head;
        //p指向链表的尾结点
        ListNode p = root;
        ListNode tmp;
        while(p.next != null &&p.next.next != null){
            //下一次要处理的位置
            tmp = p.next.next;
            //通过三个步骤进行交换
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;

            p = tmp.next;
        }
        head = root.next;
        root.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        ListNode listNode = new LinkedList().swapPairs(n1);
        if (listNode!=null){
            System.out.println(listNode.val+" ");
            listNode=listNode.next;
        }
    }
}
