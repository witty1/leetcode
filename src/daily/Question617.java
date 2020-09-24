package daily;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/23
 * @Time: 10:36
 * @Description: No Description
 */
public class Question617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null){
            return t2;
        }
        if (t2==null){
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left,t2.left);
        node.right = mergeTrees(t1.right,t2.right);
        return node;
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
