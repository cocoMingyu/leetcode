package algorithm.dp;

/**
 * @ Author : kn
 * @ Description :198. 打家劫舍
 * 中等
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * @ Date : 2024/12/21 18:47
 */
public class Rob {
    /**
     * 思路：
     * 1.定义状态 dp[i] 表示偷窃 i 号房屋所得的最高金额
     * 2.确定状态转移方程
     *   每个房屋只有两种选择：偷窃或者不偷窃
     *   dp[i] 不偷时：dp[i] = dp[i-1]
     *   dp[i] 偷时，i的前一个房屋不能偷：dp[i] = dp[i-2] + nums[i]
     *   方程：dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1])
     * 3.初始化和边界条件
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        //dp[i-1]17549685825175
        int last1=0;
        //dp[i-2]
        int last2=0;
        for (int i = 0; i < nums.length; i++) {
            int num = Math.max(last1,last2+nums[i]);
            last1=num;
            last2=last1;
        }
        return last1;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{2, 1, 1, 3, 10, 1, 15, 30, 12, 15, 35, 30}));
    }
}
