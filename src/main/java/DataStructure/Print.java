package DataStructure;

import DataStructure.List.LinkedList;

import java.util.*;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/2/17 12:50
 * @ Modified By:
 */
public class Print {
    public void test1(int x){
        long start = System.currentTimeMillis();
        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            list.add(0,i);
        }
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            if ((int)iterator.next()%2==0){
                iterator.remove();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("for time:"+(end-start));
    }
    public void test2(int x){
        long start = System.currentTimeMillis();
        List list= (List) new LinkedList();
        for (int i = 1; i <= x; i++) {
            list.add(0,i);
        }

        long end = System.currentTimeMillis();
        System.out.println("for time:"+(end-start));
    }

    public void addArr(){
        int[] arr={1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < 8; i++) {
            int j = arr[++i];
            System.out.println(j);
        }

    }

    public static void main(String[] args) {
        Print print = new Print();
/*        new Print().test1(100000);
        new Print().test2(2);*/
        print.addArr();
    }
}
