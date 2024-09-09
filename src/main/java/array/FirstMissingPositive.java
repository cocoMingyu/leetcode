package array;

/**
 * @ Author : kn
 * @ Description :41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * <p>
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * <p>
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * @ Date : 2024/9/7 16:33
 */
public class FirstMissingPositive {
    public static int test(int[] nums) {
        int n = nums.length;
        // 第一次循环如果没有1,直接返回1
        boolean hasOne = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                hasOne = true;
                break;
            }
        }
        if (!hasOne)
            return 1;
        // 将小于1的数改为n+1，数字全变为正数
        for (int i = 0; i < n; i++) {
            if (nums[i] < 1) {
                nums[i] = n + 1;
            }
        }
        // 理想情况下{0,n}区间内1,2,3依次递增 i+1=nums[i]，下标代表数字 下标0表示1，下标1表示2
        // 使用数组来计算数字是否出现过,，如果出现过，它的下标所对应的数改为复数，例如遍历到下标2的数字=5，按照上面公式i+1=5，下标4的数字改为负数
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) > n) {
                continue;
            }
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }

        for (int i = 0; i < n; i++) {
            // 第一个出现的元素大于0，说明该下标所对应的数字没有出现过
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 完整按照顺序排列1,2,3.. 缺失正整数是n+1;
        return n + 1;
    }

    //使用置换 理想情况下{0,n}区间内1,2,3依次递增 i+1=nums[i]。每次循环把数字放到正确的位置，
    //例如遍历到下标2的数字=5，按照上面公式i+1=5，下标2的数字放到下标4的位置，下标4的数字放到下标2的位置，以此类推，直到遍历完数组
    public static int test2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //下标上的数字与下标不匹配，则进行置换，过滤掉小于1的数字或者不在{0，n}区间内的数
            while (num > 0 && num < n && nums[num - 1] != num) {
                int temp = nums[num - 1];
                nums[num - 1] = num;
                nums[i] = temp;
                num = nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if ( nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
        System.out.println(test2(new int[]{-1,4,2,1,9,10}));
        System.out.println(test2(new int[]{3, 4, -1, 1}));
    }
}
