package weekly.contest320;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-320/
 * @since 2022/11/20 20:44
 */
public class Question320 {
    // 1 2 3 3 5 5
    public int unequalTriplets(int[] nums) {
        Set<Integer[]> set = new HashSet<>();
        recur(nums, 0, 0, 0, set);
        return set.size();
    }

    private void recur(int[] nums, int i, int j, int index, Set<Integer[]> set) {
        int a = 0;
        if (index == 1) {
            a = i + 1;
        } else if (index == 2) {
            a = j + 1;
        }
        for (; a < nums.length; a++) {
            if (index == 0) {
                recur(nums, a, 0, index + 1, set);
            } else if (index == 1) {
                if (nums[i] != nums[a]) {
                    recur(nums, i, a, index + 1, set);
                }
            } else {
                if (nums[i] != nums[a] && nums[j] != nums[a]) {
                    Integer[] ans = {nums[i], nums[j], nums[a]};
                    set.add(ans);
                }
            }
        }
    }


    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>(queries.size() >> 1);
        dfs(root, nums);
        for (Integer query : queries) {
            ArrayList<Integer> temp = new ArrayList<>();
            int min = binarySearch(query, nums);
            if (min < 0) {
                temp.add(-1);
                temp.add(nums.get(0) >= query ? nums.get(0) : -1);
            } else if (min >= nums.size()) {
                temp.add(-1);
                temp.add(-1);
            } else {
                Integer e = nums.get(min);
                temp.add(e);
                if (e.equals(query)) {
                    temp.add(e);
                } else {
                    temp.add(min + 1 < nums.size() ? nums.get(min + 1) : -1);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    private int binarySearch(int target, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (true) {
            if (l > r) {
                return l - 1;
            }
            int mid = l + ((r - l) >> 1);
            Integer num = list.get(mid);
            if (num > target) {
                r = mid - 1;
            } else if (num < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
    }

    private void dfs(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        dfs(root.left, nums);
        nums.add(root.val);
        dfs(root.right, nums);
    }

    long ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0){
            return ans;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(roads.length);
        for (int[] road : roads) {
            List<Integer> zero = map.getOrDefault(road[0], new ArrayList<>());
            List<Integer> one = map.getOrDefault(road[1], new ArrayList<>());
            zero.add(road[1]);
            one.add(road[0]);
            map.put(road[0], zero);
            map.put(road[1], one);
        }
        dfs(map, 0, -1, seats);
        return ans;
    }

    public long dfs(Map<Integer, List<Integer>> map, int cur, int parent, int seat) {
        long size = 1;
        for (Integer integer : map.get(cur)) {
            if (integer != parent) {
                size += dfs(map, integer, cur, seat);
            }
        }
        if (cur != 0){
            ans += (int)Math.ceil((double) size / seat);
        }
        return size;
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

    public static void main(String[] args) {
        Question320 question320 = new Question320();
        question320.unequalTriplets(new int[]{4, 4, 2, 4, 3});
    }
}
