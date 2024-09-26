package tree;

/**
 * @ Author : kn
 * @ Description :二叉树的直径
 * 简单
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 *
 * 示例 2：
 * 输入：root = [1,2]
 * 输出：1
 *
 * 提示：
 * 树中节点数目在范围 [1, 104] 内
 * -100 <= Node.val <= 100
 * @ Date : 2024/9/23 15:17
 */
public class DiameterOfBinaryTree {
    int length;
    /**
     * 找到每个节点两条最长的树，节点相加-1既是长度
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        length=1;
        deep(root);
        return length-1;
    }

    public int deep(TreeNode root){
        //空节点返回0
        if(root == null){
            return 0;
        }
        //当前节点的左右树深度
        int ll = deep(root.left);
        int rl = deep(root.right);
        //当前节点所经过的节点数，需要加上根节点
        length = Math.max(ll + rl+1,length);
        //返回节点最大深度
        return Math.max(ll,rl)+1 ;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(11);
        root.right.left.left.left = new TreeNode(111);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(33);
        root.right.right.left.right = new TreeNode(333);
        root.right.right.left.right.right = new TreeNode(3333);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
}
