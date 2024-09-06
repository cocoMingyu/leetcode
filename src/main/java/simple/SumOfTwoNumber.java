package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: lkn
 * @ Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 * @ Date:Created in 2019/2/14 9:31
 * @ Modified By:
 */
public class SumOfTwoNumber {
    public void test(){
        int[] num={2,7,11,23};
        int target=9;
        int[] answer=new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = num.length-i-1; j >0; j--) {
                if (num[i] + num[j] == target){
                    answer[0]=num[i];
                    answer[1]=num[j];
                }
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {

    }
}
