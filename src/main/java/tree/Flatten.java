package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : kn
 * @ Description :114. 二叉树展开为链表
 * 中等
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * @ Date : 2024/10/15 10:38
 */
public class Flatten {
    public void flatten(TreeNode root) {
        List<TreeNode> copy = new ArrayList<>();
        recursion(root, copy);
        if (copy.size()<=1){
            return;
        }
        TreeNode next = root;
        for (int i = 1; i < copy.size(); i++) {
            next.right=copy.get(i);
            next.left=null;
            next=next.right;
        }
    }

    public void recursion(TreeNode root, List<TreeNode> copy) {
        if (root == null) {
            return;
        }
        copy.add(root);
        recursion(root.left, copy);
        recursion(root.right, copy);
    }

    public void flatten2(TreeNode root) {
        TreeNode copy = new TreeNode(root.val);
        recursion(root, copy);
        System.out.println();
    }

    public void recursion(TreeNode root, TreeNode copy) {
        if (root == null) {
            return;
        }
        copy.right = new TreeNode(root.val);
        copy=copy.right;
        recursion(root.left, copy);
        recursion(root.right, copy);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -9, -8, -7, -3, 0, 5, 9, 11, 12, 14};
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(nums);
        Flatten flatten = new Flatten();
        flatten.flatten2(treeNode);
        System.out.println();
    }
}