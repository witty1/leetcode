package daily;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/12
 * @Time: 15:49
 * @Description: https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            Double count = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                count += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            list.add(count / size);

        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);

        System.out.println(averageOfLevels(node));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
