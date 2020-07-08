package daily;

import com.sun.deploy.panel.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/8
 * @Time: 17:05
 * @Description: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
 */
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        cr(root, list);
        return list;
    }

    public void cr(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                cr(root.left, res);
            }
            if (root.right != null) {
                cr(root.right, res);
            }
            res.add(root.val);
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
