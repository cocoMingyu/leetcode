package tree;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
