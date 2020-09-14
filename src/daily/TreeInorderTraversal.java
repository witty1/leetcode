package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/14
 * @Time: 13:40
 * @Description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 9.14 二叉树的中序遍历
 * 中序遍历：左子树——根节点——右子树
 */
public class TreeInorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
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
