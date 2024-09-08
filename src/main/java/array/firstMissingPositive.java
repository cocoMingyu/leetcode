package array;

public class firstMissingPositive {
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
                nums[i] = n+1;
            }
        }
        // 理想情况下{0,n}区间内1,2,3依次递增 i+1=nums[i]，下标代表数字 下标0表示1，下标1表示2
        // 使用数组来计算数字是否出现过,，如果出现过，它的下标所对应的数改为复数，例如遍历到下标2的数字=5，按照上面公式i+1=5，下标4的数字改为负数
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i])>n){
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

    public static void main(String[] args) {
        System.out.println(test(new int[]{1, 2, 0}));
        System.out.println(test(new int[]{3,4,-1,1}));
    }
}
