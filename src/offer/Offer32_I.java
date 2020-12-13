package offer;

import tree.TreeNode;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/13
 * @Time: 10:36
 * @Description: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class Offer32_I {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
//        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
