package weekly.contest311;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-311/
 * @since 2022/9/19 15:57
 */
public class Question311 {

    public int smallestEvenMultiple(int n) {
        if ((n & 1) == 0) {
            return Math.max(2, n);
        }
        return 2 * n;
    }


    public int longestContinuousSubstring(String s) {
        int ans = 1;
        char[] array = s.toCharArray();
        int temp = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] == 1) {
                temp++;
            } else {
                ans = Math.max(temp, ans);
                temp = 1;
            }
        }
        return Math.max(temp, ans);
    }

    public static TreeNode reverseOddLevels1(TreeNode root) {
        int level = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Deque<Integer> numDeque = new ArrayDeque<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    if ((level & 1) == 1) {
                        numDeque.addFirst(node.left.val);
                        numDeque.addFirst(node.right.val);
                    }
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                }
            }
            if ((level++ & 1) == 1) {
                deque.forEach(node -> node.val = numDeque.pollFirst());
            }
        }
        return root;
    }


    public static TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    public static void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null) {
            return;
        }
        if ((level & 1) == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(0);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(0);
        node.left.left.left = new TreeNode(1);
        node.left.left.right = new TreeNode(1);
        node.left.right.left = new TreeNode(1);
        node.left.right.right = new TreeNode(1);
        node.right.left.left = new TreeNode(2);
        node.right.left.right = new TreeNode(2);
        node.right.right.left = new TreeNode(2);
        node.right.right.right = new TreeNode(2);
        reverseOddLevels(node);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
