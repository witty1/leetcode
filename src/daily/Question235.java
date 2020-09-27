package daily;

import java.util.LinkedList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/27
 * @Time: 12:09
 * @Description: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Question235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new LinkedList<>();
        List<TreeNode> qList = new LinkedList<>();
        TreeNode ancestor = null;
        build(root, p, pList);
        build(root, q, qList);
        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i) == qList.get(i)) {
                ancestor = pList.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public void build(TreeNode root, TreeNode t, List<TreeNode> list) {
        if (root.val == t.val) {
            list.add(root);
            return;
        }
        list.add(root);
        if (root.val > t.val) {
            build(root.left, t, list);
        } else {
            build(root.right, t, list);
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
