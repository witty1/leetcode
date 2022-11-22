package offer;

import tree.TreeNode;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/18
 * @Time: 15:08
 * @Description: No Description
 */
public class Offer55_II {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recur(node.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(node.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
