package offer;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/12
 * @Time: 10:02
 * @Description: https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 镜像二叉树左节点左子树的值等于右节点右子树的值，左节点右子树的值等于右节点左子树的值，递归判断即可。
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || judgeMirror(root.left, root.right);
    }

    private boolean judgeMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return judgeMirror(left.left, right.right) && judgeMirror(left.right, right.left);
    }


}
