package simple;

/**
 * @ Author:lkn
 * @ Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * @ Date:Created in 2019/2/14 11:50
 * @ Modified By:
 */
public class HuiWenShu {
    public boolean isPalindrome(int x){
       int num=x;
       int reverse=0;
       while(x!=0){
           int a=x%10;
           x/=10;
           reverse=reverse*10+a;
       }
       return num>=0&&num==reverse;
    }

    public static void main(String[] args) {
        boolean palindrome = new HuiWenShu().isPalindrome(0);
        System.out.println(palindrome);
    }
}
