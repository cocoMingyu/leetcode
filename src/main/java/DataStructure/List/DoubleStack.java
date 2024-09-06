package DataStructure.List;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/2/19 19:08
 * @ Modified By:
 */
public class DoubleStack {
     private int length;
     private int[] arr;
     private int top1,top2;

     public void doubleStack(int num){
         length=num;
         arr=new int[length];
         top1=-1;
         top2=length;
     }

     public boolean push1(int a){
         if (top1+1==top2){
             return false;
         }else {
             top1=top1+1;
             arr[+top1]=a;
             return true;
         }
     }

     public boolean pop1(){
         if (top1==-1){
             return false;
         }else {
             top1--;
             return true;
         }
     }

     public boolean push2(int a){
         if (top2-1==top1){
             return false;
         }
         top2=top2-1;
         arr[top2]=a;
         return true;
     }

     public boolean pop2(){
         if (top2==length){
             return false;
         }
         top2++;
         return true;
     }

     public void top1Stack(){
        if (top1==-1){
            System.out.println("空栈");
        }else {
            for (int i = 0; i <=top1; i++) {
                System.out.println("stack1 "+arr[i]);
            }
        }
     }

    public void top2Stack(){
        if (top2==length){
            System.out.println("空栈");
        }else {
            for (int i =length-1; i >top1; i--) {
                System.out.println("stack2 "+arr[i]);
            }
        }
    }

     public static void main(String[] args) {
         DoubleStack stack = new DoubleStack();
         stack.doubleStack(10);
         stack.push1(1);
         stack.push1(1);
         stack.push1(6);

         stack.push2(10);
         stack.push2(9);
         stack.push2(8);
         stack.push2(7);

         stack.top1Stack();
         stack.top2Stack();
     }
}
