package DataStructure.List;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/2/19 17:47
 * @ Modified By:
 */
public class CircularLinkedList {
    class Element{
        public Object value=null;
        private Element next=null;
    }
    private Element head=null;

    public void init(){
        head=new Element();
        head.value=null;
        head.next=head;
    }

    void insertList(Object o){
        Element e = new Element();
        e.value=o;
        if (head.next==head){
            head.next=e;
            e.next=head;
        }
        else {
            Element temp = head;
            while (temp.next!=head){
                temp=temp.next;
            }
            temp.next=e;
            e.next=head;
        }
    }

    void delete(Object o){
        Element temp=head;
        while (temp.next!=head){
            if (temp.next.value.equals(o)){
                System.out.println("delete:"+temp.next.value);
                temp.next=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
    }

    Integer size(){
        Element temp=head;
        Integer count=0;
        while(temp.next!=head){
            count++;
            temp=temp.next;
        }
        return count;
    }

    void print(){
        Element temp=head;
        while (temp.next!=head){
            System.out.println(temp.next.value);
            temp=temp.next;
        }
    }

    void caozuo(int count){
        Element temp=head;
        while (size()>1){
            for (int i = 1; i <=count; i++) {
                temp=temp.next;
            }
            delete(temp.next.value);
        }
    }

    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        clist.init();
        Integer man=5;
        Integer count=0;
        for (int i = 1; i <=man; i++) {
            clist.insertList(i);
        }

        clist.caozuo(count);
        clist.print();
    }

}
