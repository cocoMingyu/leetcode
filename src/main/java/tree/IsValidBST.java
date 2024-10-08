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
        return judge(root, root.val);
    }

    public boolean judge(TreeNode root,int beforeNodeVal){
        if (root==null){
            return true;
        }
        //左子树节点值大于当前节点值，右子树节点值小于当前节点值 不符合二叉搜索树
        if ((root.left!=null&&(root.left.val>=root.val||root.left.val>=v))||
                (root.right!=null&&(root.right.val<=root.val||root.right.val<=v))){
            return false;
        }
        return judge(root.left)&&judge(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        //[5,4,6,null,null,3,7]
        System.out.println(new IsValidBST().isValidBST(root));
    }
}
