package tree;

/**
 * @ Author : kn
 * @ Description :437. 路径总和 III
 * 中等
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * [1,null,2,null,3,null,4,null,5]
 * @ Date : 2024/10/30 9:49
 */
public class PathSum {
    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root==null){
            return result;
        }
        sum(root, (long) targetSum,0L);
        //每个节点都要遍历，重新调用pathsum
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return result;
    }

    public void sum(TreeNode root, Long target,Long sum) {
        if (root == null) {
            return;
        }
        long val = (long)root.val;
        if (val+sum  == target) {
            result ++;
        }
        sum(root.left, target, sum+val);
        sum(root.right, target,sum+val);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1000000000);
        treeNode2.left = new TreeNode(1000000000);
        treeNode2.left.left = new TreeNode(294967296);
        treeNode2.left.left.left = new TreeNode(1000000000);
        treeNode2.left.left.left.left = new TreeNode(1000000000);
        treeNode2.left.left.left.left.left = new TreeNode(1000000000);


        System.out.println(new PathSum().pathSum(treeNode2, 0));
    }
}
