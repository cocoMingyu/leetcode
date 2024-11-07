package tree;

/**
 * @ Author : kn
 * @ Description :124. 二叉树中的最大路径和
 * 困难
 * 相关标签
 * 相关企业
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * @ Date : 2024/11/6 20:20
 */
public class MaxPathSum {
    private int res = -1000000;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return res;
    }

    //求出左右子树路径和，并比较
    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(findMax(root.left), 0);
        int right = Math.max(findMax(root.right), 0);
        //左右子树+当前节点的最大值，这个值需要返回给上一层
        int sum = Math.max(root.val + left, root.val + right);
        //把当前节点作为根节点求和，与左右子树比较
        int single = Math.max(root.val + left + right, sum);
        if (single > res) {
            res = single;
        }
        return sum;
    }

    public static void main(String[] args) {
        //[1,-2,-3,1,3,-2,null,-1]
        TreeNode treeNode = new TreeNode(-3);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(-1);


        TreeNode treeNode2 = new TreeNode(-1);


        int i = new MaxPathSum().maxPathSum(treeNode);
        System.out.println(i);
    }
}
