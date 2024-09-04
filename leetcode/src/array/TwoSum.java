package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author : kn
 * @ Description :给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 * @ Date : 2024/8/31 10:43
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int secondNum = nums[j];
                if (firstNum + secondNum == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        //key-数字，value-下标
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum2(nums, target);
        System.out.println(ints[0]+"\t"+ints[1]);
    }
}
