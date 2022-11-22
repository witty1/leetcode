package offer;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/19
 * @Time: 14:58
 * @Description: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class Offer68_I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < q.val && root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val && root.val > p.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
