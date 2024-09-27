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
    int[] arr;
    int left;
    int right;
    public TreeNode sortedArrayToBST(int[] nums) {
        arr = nums;
        int length = nums.length;
        //确定根节点，为数组中间元素
        TreeNode root = new TreeNode(nums[length / 2]);
         left = length / 2 - 1;
         right = length / 2 + 1;
        if (left>=0){
            TreeNode l = new TreeNode(arr[left--]);
            root.left=l;
            buildLeftTree(l);
        }
        if (right<length){
            TreeNode r = new TreeNode(arr[right++]);
            root.right=r;
            buildRightTree(r);
        }
        return root;
    }

    public void buildLeftTree(TreeNode root){
        if (left<0){
            return;
        }
        root.left=new TreeNode(arr[left--]);
        if (left<0){
            return;
        }
        root.right=new TreeNode(arr[left--]);
        buildLeftTree(root.left);
        buildLeftTree(root.right);
    }

    public void buildRightTree(TreeNode root){
        if (right>=arr.length){
            return;
        }
        root.left=new TreeNode(arr[right++]);
        if (right>=arr.length){
            return;
        }
        root.right=new TreeNode(arr[right++]);
        buildRightTree(root.left);
        buildRightTree(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10,-9,-8,-7,-3,0,5,9,11,12,14};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}
