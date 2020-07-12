package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/12
 * @Time: 9:59
 * @Description: https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    Integer x = null;
    public boolean isValidBST(TreeNode root) {

        try {
            valid(root);
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public void valid(TreeNode root) throws Exception {
        if (root != null) {
            if (root.left != null) {
                valid(root.left);
            }
            if (x!=null&&root.val<=x){
                throw new Exception();
            }else {
                x = root.val;
            }

            if (root.right!=null){
                valid(root.right);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
