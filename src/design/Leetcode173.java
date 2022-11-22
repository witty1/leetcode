package design;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author zhengcp
 * @version V2.1
 * @since 2021/12/13 15:48
 * @description: https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class Leetcode173 {
    class TreeNode {
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

    /**
     * 提前保存所有数据
     */
    class BSTIterator {
        ArrayList<Integer> list;
        int idx;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            dfs(root);
        }

        public void dfs(TreeNode root){
            if (root == null){
                return;
            }
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        public int next() {
            return list.get(idx++);
        }

        public boolean hasNext() {
            return idx < list.size();
        }
    }

    /**
     * 迭代解决
     */
    class BSTIterator1 {
        Deque<TreeNode> stack;
        TreeNode cur;

        public BSTIterator1(TreeNode root) {
            cur = root;
            stack = new LinkedList<>();

        }



        public int next() {
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }

        public boolean hasNext() {
            return cur !=null || !stack.isEmpty();
        }
    }
}
