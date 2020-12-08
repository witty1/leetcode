package offer;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/8
 * @Time: 21:05
 * @Description: No Description
 */
public class Offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public TreeNode construct(int[] preOrder, int pre_left, int pre_right, int[] inOrder, int inOrder_left, int inOrder_right, Map<Integer, Integer> map) {
        if (pre_left >= pre_right) {
            return null;
        }
        int rootIndex = preOrder[pre_left];
        //构建根节点
        TreeNode root = new TreeNode(rootIndex);
        //从中序遍历获取根节点在中序遍历的位置，其左边为左子树，右边为右子树
        int left = map.get(rootIndex);
        int leftNum = left - inOrder_left;
        root.left = construct(preOrder, pre_left + 1, pre_left + leftNum + 1, inOrder, inOrder_left, left, map);
        root.right = construct(preOrder, pre_left + leftNum + 1, pre_right, inOrder, left + 1, inOrder_right, map);
        return root;
    }
}


