package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ Author : kn
 * @ Description :199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * 示例 3:
 * 输入: []
 * 输出: []
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 * @ Date : 2024/10/14 17:54
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<Integer> res = new LinkedList();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (i == 0) {
                    res.add(node.val);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*int[] nums = {-10, -9, -8, -7, -3, 0, 5, 9, 11, 12, 14};
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(nums);*/
        TreeNode treeNode = new TreeNode(100);
        treeNode.left = new TreeNode(50);
        treeNode.right = new TreeNode(300);
        treeNode.left.left = new TreeNode(20);
        treeNode.left.right = new TreeNode(70);
        treeNode.left.right.right = new TreeNode(80);
        treeNode.left.right.right.left = new TreeNode(75);

        List<Integer> list = new RightSideView().rightSideView(treeNode);
        System.out.println(list);
    }
}
