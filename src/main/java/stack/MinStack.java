package stack;

import java.util.Arrays;

/**
 * @ Author : kn
 * @ Description :
 * @ Date : 2024/11/19 20:41
 */
public class MinStack {
    int[] arr;
    int[] minArr;
    int count=0;



    public MinStack() {
        arr=new int[1024];
        minArr = new int[1024];
        minArr[0]=Integer.MAX_VALUE;
    }

    public void push(int val) {
        //扩容
        if (arr.length-count<1){
            arr=Arrays.copyOf(arr,arr.length*2);
            minArr=Arrays.copyOf(minArr,minArr.length*2);
        }
        count++;
        arr[count-1]=val;
        minArr[count-1]=Math.min(val,minArr[Math.max(count - 2, 0)]);
    }

    public void pop() {
        arr[count-1]=0;
        minArr[count-1]=Integer.MAX_VALUE;
        count--;
    }

    public int top() {
        return arr[count-1];
    }

    public int getMin() {
        return minArr[count-1];
    }

    public static void main(String[] args) {
        /*MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());*/

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
