package offer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/12
 * @Time: 10:50
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class Offer34 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    int count = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    public void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        count += root.val;
        recur(root.left, sum);
        recur(root.right, sum);
        if (root.left == null && root.right == null && count == sum) {
            res.add(new LinkedList<>(temp));
        }
        count -= root.val;
        temp.removeLast();
    }

    public static void main(String[] args) {
        Offer34 offer34 = new Offer34();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);
        offer34.pathSum(treeNode, 22).forEach(System.out::println);
    }

}
