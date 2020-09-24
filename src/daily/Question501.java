package daily;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/24
 * @Time: 8:26
 * @Description: https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class Question501 {

    List<Integer> list = new ArrayList<>();
    int max = 0;
    int cur = 0;
    int now = 0;

    public int[] findMode(TreeNode root) {
        find(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void find(TreeNode root) {
        if (root == null) {
            return;
        }
        find(root.left);
        if (cur == root.val) {
            ++now;
        } else {
            cur = root.val;
            now = 1;
        }

        if (now > max) {
            list.clear();
            list.add(root.val);
            max = now;
        } else if (now == max) {
            list.add(root.val);
        }
        find(root.right);
    }


    static Map<Integer, Integer> map = new HashMap<>();
    static int max1 = 0;

    public static int[] findMode1(TreeNode root) {
        find1(root);
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Object[] array = set.stream().filter(o -> o.getValue() == max1).map(Map.Entry::getKey).toArray();
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = (int) array[i];
        }
        return res;
    }

    public static void find1(TreeNode root) {
        if (root == null) {
            return;
        }
        find1(root.left);
        if (map.containsKey(root.val)) {
            Integer count = map.get(root.val);
            map.put(root.val, ++count);
            max1 = count > max1 ? count : max1;
        } else {
            map.put(root.val, 1);
            max1 = Math.max(max1, 1);
        }
        find1(root.right);
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
