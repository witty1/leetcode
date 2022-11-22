package weekly.contest283;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/contest/weekly-contest-283
 * @since 2022/3/6 10:35
 */
public class Question {
    public List<String> cellsInRange(String s) {
        ArrayList<String> list = new ArrayList<>();
        String[] split = s.split(":");
        int row1 = (int) split[0].charAt(1) - '0';
        int row2 = (int) split[1].charAt(1) - '0';
        char col1 = split[0].charAt(0);
        char col2 = split[1].charAt(0);
        int r = row1;
        while (true) {
            if (col1 <= col2) {
                if (r <= row2) {
                    list.add(col1 + String.valueOf(r));
                    r++;
                }
            }
            if (r > row2) {
                r = row1;
            } else {
                continue;
            }
            if (col1 == col2) {
                break;
            } else {
                col1++;
            }

        }
        return list;
    }

    public long minimalKSum(int[] nums, int k) {
        long res = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        nums = new int[treeSet.size()];
        int i = 0;
        for (Integer integer : treeSet) {
            nums[i++] = integer;
        }
        i = 1;
        for (int j = 0; j < nums.length && k > 0; j++) {
            if (nums[j] != i) {
                res += i;
                k--;
            }
            i++;
            if (j + 1 < nums.length && nums[j + 1] != i) {
                j--;
            }
        }
        res += ((long) (i + i + k - 1) * k) >> 1;
        int len = nums.length - 1;
        return i < nums[len] && i + k > nums[len] ? ++res : res;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, Integer> nodes = new HashMap<>(descriptions.length);
        HashMap<Integer, ArrayList<int[]>> parents = new HashMap<>(descriptions.length);
        for (int[] description : descriptions) {
            nodes.put(description[1], 1);
            ArrayList<int[]> list = parents.getOrDefault(description[0], new ArrayList<>());
            list.add(description);
            parents.put(description[0], list);
        }
        TreeNode head = null;
        for (Integer next : parents.keySet()) {
            //找到根节点
            if (nodes.get(next) == null) {
                head = new TreeNode(next);
                break;
            }
        }
        TreeNode temp = head;
        build(temp, parents);
        return head;
    }

    public void build(TreeNode temp, HashMap<Integer, ArrayList<int[]>> parents) {
        if (temp == null) {
            return;
        }
        ArrayList<int[]> list = parents.get(temp.val);
        if (list == null || list.size() == 0){
            return;
        }
        //递归构造左右子树
        for (int[] tree : list) {
            if (tree[2] == 1) {
                temp.left = new TreeNode(tree[1]);
            } else {
                temp.right = new TreeNode(tree[1]);
            }
        }
        build(temp.left, parents);
        build(temp.right, parents);
    }

    public static void main(String[] args) {
//        System.out.println(new Question().cellsInRange("K1:L2"));
//        System.out.println(new Question().minimalKSum(new int[]{1,4,25,10,25}, 2));
        System.out.println(new Question().minimalKSum(new int[]{1000000000}, 1000000000));
        System.out.println(new Question().minimalKSum(new int[]{5, 6}, 6));
//        System.out.println(new Question().minimalKSum(new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84}, 35));
    }

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

}
