package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author : kn
 * @ Description :46. 全排列
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * @ Date : 2024/11/11 20:00
 */
public class Permute {
    Map<Integer,Boolean> existsMap=new HashMap<>();
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        addElement(result,new ArrayList<>(),nums);
        return result;
    }

    public void addElement(List<List<Integer>> result,List<Integer> arr,int[] nums){
        // 递归结束条件，如果数组的长度等于nums的长度，则添加到结果集中
        if(arr.size()==nums.length){
            result.add(arr);
            return;
        }
        // 遍历nums，如果当前元素不在map中，则添加到arr中，并递归调用addElement
        for(int i=0;i<nums.length;i++){
            if(!existsMap.containsKey(nums[i])){
                List<Integer> newArr=new ArrayList<>(arr);
                newArr.add(nums[i]);
                existsMap.put(nums[i],true);
                addElement(result,newArr,nums);
                // 递归结束后，移除当前元素
                existsMap.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Permute().permute(new int[]{1,2,3});
        System.out.println(permute);
    }
}
