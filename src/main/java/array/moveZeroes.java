package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author : kn
 * @ Description :
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @ Date : 2024/8/31 16:09
 */
public class moveZeroes {
    public static void  moveZeroes(int[] nums) {
        int notZeroIndex =0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num!=0){
                nums[notZeroIndex]=num;
                notZeroIndex++;
            }
        }
        for (int i = notZeroIndex; i < nums.length; i++) {
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int[] ints = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(ints);
        System.out.println();

    }
}
