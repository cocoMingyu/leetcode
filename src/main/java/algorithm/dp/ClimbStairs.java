package algorithm.dp;

/**
 * @ Author : kn
 * @ Description :70. 爬楼梯
 * 简单
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 提示：
 *
 * 1 <= n <= 45
 * @ Date : 2024/12/21 16:56
 */
public class ClimbStairs {

    public int climbStairs2(int n) {
        /**
         * f(x)=f（x-1）+f(x-2)
         * 每次只能迈1,2步，当到达楼顶时，退一步为f(x-1),退两步为f(x-2) 所以结果为两项的和
         */

       int res=0,one=1,two=2;
       if (n<=2)
           return n;
        for (int i = 3; i <=n; i++) {
             res=one+two;
             one = two;
             two=res;
        }
        return res;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs2(5));
    }
}
