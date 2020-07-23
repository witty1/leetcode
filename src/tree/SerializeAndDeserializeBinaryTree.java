package tree;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/22
 * @Time: 8:39
 * @Description: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        recu(root,sb);
        return sb.toString();
    }

    public static void recu(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        recu(root.left,sb);
        recu(root.right,sb);
    }

    public static TreeNode ser(LinkedList<String> list){
        if ("null".equals(list.get(0))){
            list.remove(0);
            return null;
        }
        TreeNode t = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        t.left = ser(list);
        t.right = ser(list);
        return t;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");

        return ser(new LinkedList<>(Arrays.asList(split)));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = null;
        treeNode.left.right = null;
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.left.left = null;
        treeNode.right.left.right = null;
        treeNode.right.right = new TreeNode(5);
        treeNode.right.right.left = null;
        treeNode.right.right.right = null;
        String s = serialize(treeNode);
        deserialize(s);
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
