package tree;

/**
 * @ Author : kn
 * @ Description :108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
 * 平衡
 *  二叉搜索树。
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。

 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 * @ Date : 2024/9/27 10:03
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0,nums.length-1,nums);
    }

    public TreeNode buildTree(int left, int right, int[] nums){
        // 递归终止条件，左边界超过右边界
        if (left > right){
            return null;
        }
        //选取中间节点
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildTree(left,mid-1,nums);
        root.right=buildTree(mid+1,right,nums);
        return root;
    }




    public static void main(String[] args) {
        int[] nums = {-10,-9,-8,-7,-3,0,5,9,11,12,14};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}
