package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/8
 * @Time: 15:30
 * @Description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recu(root,list);
        return list;
    }

    public void recu(TreeNode root,List<Integer> list){
        if (root!=null){
            list.add(root.val);
            if (root.left!=null){
                recu(root.left,list);
            }
            if (root.right!=null){
                recu(root.right,list);
            }
        }

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
