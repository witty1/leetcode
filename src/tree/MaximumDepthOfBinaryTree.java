package tree;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/17
 * @Time: 10:30
 * @Description: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    int max = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        dep(root, 0);
        return max;
    }

    public void dep (TreeNode root, int dep){
        if (root==null){
            max = Math.max(max, dep);
            return;
        }
        dep(root.left,dep+1);
        dep(root.right,dep+1);
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
