package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : kn
 * @ Description :236. 二叉树的最近公共祖先
 * 中等
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * @ Date : 2024/10/31 15:29
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pL=new ArrayList<>();
        List<TreeNode> qL=new ArrayList<>();
        //先找到包含两个节点的路径
        //两个路径的最后一个相同节点就是最近公共祖先
        findPath(root,p,pL);
        findPath(root,q,qL);
        for (int i = 0; i < pL.size() && i < qL.size(); i++) {
            if (pL.get(i).val!=qL.get(i).val){
                return pL.get(i-1);
            }
        }
        return null;
    }

    public boolean findPath(TreeNode root, TreeNode tar,List<TreeNode> list){
        if (root==null){
            return false;
        }
        if (root.val!= tar.val){
            boolean b = findPath(root.left, tar, list) || findPath(root.right, tar, list);
            if (b){
                list.add(root);
            }
            return b;
        }else {
            list.add(root);
            return true;
        }
    }
}
