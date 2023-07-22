package weekly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-353
 * @since 2023/7/9 10:29
 */
public class Weekly353 {
    public int theMaximumAchievableX(int num, int t) {
        return t * 2 + num;
    }

    public int maximumJumps(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(nums, 0, 0, target, set);
    }

    private int dfs(int[] nums, int i, int cnt, int target, Set<Integer> set) {
        if (i >= nums.length-1) {
            return cnt;
        }
        int ans = -1;
        for (int j = i + 1; j < nums.length; j++) {
            if (!set.contains(j) && Math.abs(nums[j] - nums[i]) <= target) {
                ans = Math.max(dfs(nums, j, cnt + 1, target, set), ans);
                if (ans == -1) {
                    set.add(j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Weekly353 weekly353 = new Weekly353();
//        System.out.println(weekly353.maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));
//        System.out.println(weekly353.maximumJumps(new int[]{1, 0, 2}, 1));
//        ArrayList<String> list = null;
        ArrayList<String> list = new ArrayList<>();
//        list.add("1");
        Optional.ofNullable(list)

                .ifPresent(l -> System.out.println(l.get(0)));
    }
}
