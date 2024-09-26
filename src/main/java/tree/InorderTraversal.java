package tree;


import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        digui(result, root);
        return result;
    }

    public void digui(List<Integer> result, TreeNode root) {
        if (root == null) return;
        digui(result, root.left);
        result.add(root.val);
        digui(result, root.right);
    }

    public static class FlagTreeNode {
        TreeNode node;
        int flag;

        public FlagTreeNode(TreeNode node, int flag) {
            this.node = node;
            this.flag = flag;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<FlagTreeNode> stack = new LinkedList<>();

        stack.push(new FlagTreeNode(root, 0));
        while (!stack.isEmpty()) {
            FlagTreeNode peek = stack.pop();
            if (peek.node == null) continue;
            //没有标记过，入栈，按照右节点，中节点，左节点顺序
            if (peek.flag == 0) {
                stack.push(new FlagTreeNode(peek.node.right, 0));
                stack.push(new FlagTreeNode(peek.node, 1));
                stack.push(new FlagTreeNode(peek.node.left, 0));
            } else {
                result.add(peek.node.val);
            }
        }
        return result;
    }
}
