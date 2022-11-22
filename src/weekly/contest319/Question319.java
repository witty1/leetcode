package weekly.contest319;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-319
 * @since 2022/11/13 10:29
 */
public class Question319 {
    public double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15d;
        ans[1] = celsius * 1.80d + 32d;
        return ans;
    }

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = nums[i];
            for (int j = 0; j < nums.length; j++) {
                cnt = cnt * nums[j] % k;
                if (cnt > k) {
                    break;
                } else if (cnt == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(a, b % a) : a;
    }

    public int minimumOperations(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = bfs(root, map);
        int ans = 0;
        int cur = 1;
        List<Integer> old = new ArrayList<>(arr.length);
        for (int j : arr) {
            old.add(j);
        }
        for (int i = 0; i < arr.length; i++) {
            Integer count = map.getOrDefault(cur, 0);
            ans += sort(arr, i, i + count);
            i = i + count - 1;
            cur++;
        }
        return ans;
    }

    public static int sort(int[] arr, int from, int to) {
        int ans = 0;
        for (int i = from; i < to; i++) {
            int min = Integer.MAX_VALUE;
            int cur = 0;
            for (int j = i + 1; j < to; j++) {
                if (arr[i] > arr[j]) {
                    min = arr[j];
                    cur = j;
                }
            }
            if (min != Integer.MAX_VALUE) {
                int temp = arr[cur];
                arr[cur] = arr[i];
                arr[i] = temp;
                ans++;
            }
        }
        return ans;
    }


    public static int[] bfs(TreeNode root, HashMap<Integer, Integer> map) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int cur = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            map.put(cur, size);

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);

                }
                if (node.right != null) {
                    deque.add(node.right);
                }

            }
            cur++;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        Question319 question319 = new Question319();
        TreeNode treeNode = new TreeNode(49);
//        treeNode.left = new TreeNode(45);
//        treeNode.right = new TreeNode(1);
//        treeNode.left.left = new TreeNode(20);
//        treeNode.left.right = new TreeNode(46);
//        treeNode.right.left = new TreeNode(15);
//        treeNode.right.right = new TreeNode(39);
//        treeNode.left.left.left = new TreeNode(27);
//        treeNode.right.left.left = new TreeNode(25);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(4);
//        treeNode.left = new TreeNode(4);
//        treeNode.right = new TreeNode(3);
//        treeNode.left.left = new TreeNode(7);
//        treeNode.left.right = new TreeNode(6);
//        treeNode.right.left = new TreeNode(8);
//        treeNode.right.right = new TreeNode(5);
//        treeNode.right.left.left = new TreeNode(9);
//        treeNode.right.right.left = new TreeNode(10);
        question319.minimumOperations(treeNode);
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
