package daily;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/10
 * @Time: 16:18
 * @Description: https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates.length == 0 || target == 0) {
            return res;
        }
        cal(res, target, candidates, 0, new ArrayDeque<>());
        return res;
    }

    public static void cal(List<List<Integer>> res, int target, int[] candidates, int n, Deque<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = n; i < candidates.length; i++) {
            if (candidates[i] > target || (i > n && candidates[i] == candidates[i - 1])) {
                continue;
            }
            temp.addLast(candidates[i]);
            cal(res, target - candidates[i], candidates, i + 1, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(num, 8);
        System.out.println(lists);

    }
}
