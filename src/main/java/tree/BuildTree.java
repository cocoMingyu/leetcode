package tree;

/**
 * @ Author : kn
 * @ Description :105. 从前序与中序遍历序列构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * @ Date : 2024/10/28 20:32
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            int i1 = preorder[i];

        }
    }
}
