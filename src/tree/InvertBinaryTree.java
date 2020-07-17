package tree;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/17
 * @Time: 9:54
 * @Description: https://leetcode-cn.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTree {
    public  TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
