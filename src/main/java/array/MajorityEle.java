package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ Author : kn
 * @ Description :  169. 多数元素
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * @ Date : 2025/10/17 19:19
 */
public class MajorityEle {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int lastCount=0,res=0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer count = map.get(num);
            if (count==null){
                count=1;
                map.put(num,count);
            }else {
                map.put(num,++count);
            }

            if (count>lastCount){
                lastCount=count;
                res=num;
            }
        }
        return res;
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    public static void main(String[] args) {
        System.out.println(majorityElement2(new int[]{2,2,1,1,1,2,2}));
    }
}
