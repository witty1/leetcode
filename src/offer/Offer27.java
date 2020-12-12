package offer;

import tree.TreeNode;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/12
 * @Time: 9:53
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 二叉树的镜像，直接递归即可
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }
}
