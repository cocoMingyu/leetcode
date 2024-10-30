package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1,0, inorder.length-1);
    }

    public TreeNode build(int[] preorder,int preStart,int preEnd,int inStart,int inEnd) {
        if (preStart>preEnd) {
            return null;
        }
        //先序遍历第一个元素是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //中序遍历中根节点的位置
        Integer rootIndex = inMap.get(rootVal);

        //确定中序左右边界，根据中序左右边界长度，确定前序左右边界
        root.left=build(preorder,preStart+1,preStart+1+(rootIndex-1-inStart),inStart,rootIndex-1);
        root.right=build(preorder,preEnd-(inEnd-rootIndex-1),preEnd,rootIndex+1,inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {2,3,1};
        TreeNode treeNode = new BuildTree().buildTree(preorder, inorder);
        System.out.println();
    }
}
