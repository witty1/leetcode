package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/8
 * @Time: 8:52
 * @Description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {



    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recu(root,list);
        return list;
    }

    public void recu(TreeNode root,List<Integer> res){
        if (root!=null){
            if (root.left!=null){
                recu(root.left,res);
            }
            res.add(root.val);
            if (root.right!=null){
                recu(root.right,res);
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
