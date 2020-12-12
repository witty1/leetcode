package offer;

import tree.TreeNode;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/7
 * @Time: 19:23
 * @Description: No Description
 */
public class Offer54 {
    int res,k;
    public int kthLargest(TreeNode root, int k){
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.right);
        if (k==0){
            return;
        }
        if (--k==0){
            res = root.val;
        }
        dfs(root.left);
    }

    public int kthLargest1(TreeNode root, int k) {
        Vector<Integer> vector = new Vector<>();
        List<Integer> list = new ArrayList<>();
        recall(root,list);
        list.sort(Integer::compareTo);
        int res = list.get(list.size()-1),count =1;
        for (int i = list.size()-2; i >=0; i--) {
            if (count==k){
                break;
            }
            if (res != list.get(i)){
                count++;
                res = list.get(i);
            }
        }
        return res;
    }

    private void recall(TreeNode root, List<Integer> num){
        if (root==null){
            return;
        }
        recall(root.left,num);
        num.add(root.val);
        recall(root.right,num);
    }

    public static void main(String[] args) {
        Offer54 offer54 = new Offer54();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(offer54.kthLargest(root, 1));
//        System.out.println(offer54.kthLargest1(root, 1));
    }
}

