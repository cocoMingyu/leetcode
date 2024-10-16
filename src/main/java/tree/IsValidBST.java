package tree;

/**
 * @ Author : kn
 * @ Description :98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。

 * 提示：
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 * @ Date : 2024/10/8 20:17
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return false;
        }
        return judge(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean judge(TreeNode root,Long min,Long max){
        if (root==null){
            return true;
        }
        //节点在一个区间内，左树最大值动态变化，右树最小值动态变化
        if (root.val<=min||root.val>=max){
            return false;
        }
        return judge(root.left, min, (long)root.val)&&judge(root.right,(long)root.val,max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);

        //[5,4,6,null,null,3,7]
        System.out.println(new IsValidBST().isValidBST(root));
    }
}
