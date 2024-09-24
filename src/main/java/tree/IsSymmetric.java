package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ Author : kn
 * @ Description : 判断是否对称树
 * @ Date : 2024/9/21 15:22
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        //return check(root.left, root.right);
        return checkByIteration(root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            //两个节点值相等，才继续递归
            return right.val == left.val && check(left.left, right.right) && check(left.right, right.left);
        } else {
            return left == null && right == null;
        }
    }


    public boolean checkByIteration(TreeNode root){
        //使用迭代比较是否对称,根节点添加两次，比较两个节点的对称节点的值
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        deque.offer(root);
        while (!deque.isEmpty()){
            TreeNode left = deque.poll();
            TreeNode right = deque.poll();

            if (left==null&&right==null){
                continue;
            }

            if (left==null||right==null||right.val!= left.val){
                return false;
            }

            //队列添加对称节点，两两一组
            deque.offer(left.left);
            deque.offer(right.right);

            deque.offer(left.right);
            deque.offer(right.left);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(3);

        System.out.println(new IsSymmetric().isSymmetric(root));
    }
}
