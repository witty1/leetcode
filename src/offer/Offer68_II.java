package offer;

import tree.TreeNode;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/19
 * @Time: 15:29
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class Offer68_II {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //当left为空时，祖先只能在右边或者不存在
        if (left == null){
            return lowestCommonAncestor(root.right,p,q);
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //当right为空时，代表祖先在左边
        if (right == null){
            return left;
        }
        //当左右均不为空时，当前节点是祖先
        return root;
    }


}
