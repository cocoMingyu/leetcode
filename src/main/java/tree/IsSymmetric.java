package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ Author : kn
 * @ Description :
 * @ Date : 2024/9/21 15:22
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        addElement(root, list);
        //由于根节点的存在数组个数是奇数，整除2是偶数，说明不是镜像。
        if (list.size()%2==0){
            return false;
        }
        for (int i = 0; i < list.size()/2; i++) {
            if (!Objects.equals(list.get(i),list.get(list.size()-i-1))){
                return false;
            }
        }
        return true;
    }

    public void addElement(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        //左右节点都是空，是叶子结点，跳过
        if (root.left == null && root.right == null){
            list.add(root.val);
        }else {
            addElement(root.left, list);
            list.add(root.val);
            addElement(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        //root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(2);
        //root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(2);
        System.out.println(new IsSymmetric().isSymmetric(root));
   }
}
