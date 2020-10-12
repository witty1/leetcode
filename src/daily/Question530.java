package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/12
 * @Time: 15:25
 * @Description: https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class Question530 {
    int res = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        min(root);
        return res;
    }

    public void min(TreeNode root) {
        if (root == null) {
            return;
        }
        min(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(Math.abs(pre - root.val), res);
            pre = root.val;
        }
        if (res==0){
            return;
        }
        min(root.right);
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
