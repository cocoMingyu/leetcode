package simple;

import java.util.Arrays;

/**
 * @ Author:lkn
 * @ Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * @ Date:Created in 2019/2/14 10:04
 * @ Modified By:
 */
public class num_reverse {
    public void test1(){
        boolean a=true;
        int x1=-10045600;
        Integer x=new Integer(x1);
        if (x<0){
            a=false;
            x=x*(-1);
        }
        char[] array = x.toString().toCharArray();
        StringBuffer sb=new StringBuffer();
        for (int i = array.length-1; i >=0; i--) {
            if (array[i]>0){
                sb.append(array[i]);
            }
        }

        Integer res = Integer.valueOf(sb.toString());
        if (!a){
            res=res*(-1);
        }
        if (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            res=0;
        }
        System.out.println(res);
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args) {
        int reverse = new num_reverse().reverse(12345);
        System.out.println(reverse);
    }
}
