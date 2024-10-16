package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : kn
 * @ Description : 230. 二叉搜索树中第 K 小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 *
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法
 * @ Date : 2024/10/14 17:18
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> data = new ArrayList<>();
        addElement(root,data,k);
        return data.get(k-1);
    }

    // 中序遍历向数组添加元素
    public void addElement(TreeNode root, List<Integer> data,int k){
        if (root==null||data.size()>=k){
            return;
        }
        addElement(root.left,data,k);
        data.add(root.val);
        addElement(root.right,data,k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(root, 3));
    }
}
