package tree;

/**
 * @ Author : kn
 * @ Description :
 * @ Date : 2024/9/21 15:20
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        int i1 = "1617cc00480d552533be5768468d1ed4".hashCode() % 30 + 1;
        System.out.println(i1);

    }
}
