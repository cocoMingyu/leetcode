package tree;

/**
 * 二叉树的最大深度
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return recursion(root, 1);
    }

    public int recursion(TreeNode root, int depth) {
        if (root == null) return depth;
        int left = recursion(root.left, depth + 1);
        int right = recursion(root.right, depth + 1);
        return Math.max(left, right);
    }
}
