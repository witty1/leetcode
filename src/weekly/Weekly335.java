package weekly;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-335/
 * @since 2023/3/7 15:59
 */
public class Weekly335 {

    public int passThePillow(int n, int time) {
        int len = n - 1;
        int left = time % len;
        int cnt = time / len;
        if ((cnt & 1) == 0) {
            return 1 + left;
        }
        return n - left;
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (deque.size() > 0) {
            int size = deque.size();
            long sum = 0l;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                sum += poll.val;
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
            queue.add(sum);
        }
        if (k <= queue.size()) {
            for (int i = 1; ; i++) {
                Long poll = queue.poll();
                if (i == k) {
                    return poll;
                }
            }
        }

        return -1;
    }


    public long kthLargestLevelSum1(TreeNode root, int k) {
        ArrayList<Long> list = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (deque.size() > 0) {
            int size = deque.size();
            long sum = 0l;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                sum += poll.val;
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
            list.add(sum);
        }
        if (k <= list.size()) {
            list.sort(Comparator.reverseOrder());
            return list.get(k - 1);
        }
        return -1;
    }

    public int findValidSplit(int[] nums) {
        long suf = 1;
        long pre = 1;
        for (int num : nums) {
            suf *= num;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            suf /= nums[i];
            pre *= nums[i];
            long left;
            if (suf >= pre) {
                left = gcd(suf, pre);
            } else {
                left = gcd(pre, suf);
            }
            if (left == 1) {
                return i;
            }
        }
        return -1;
    }

    private long gcd(long a, long b) {
        long left = Math.floorMod(a, b);
        while (left > 0) {
            a = b;
            b = left;
            left = Math.floorMod(a, b);
        }
        return b;
    }

    public static void main(String[] args) {
        Weekly335 weekly335 = new Weekly335();
        System.out.println(weekly335.findValidSplit(new int[]{4, 7, 8, 15, 3, 5, 4242, 2344, 2342, 2434, 5436, 36151, 5235, 5362}));


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
