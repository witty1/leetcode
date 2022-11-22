package weekly.contest274;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/contest/weekly-contest-274/problems/maximum-employees-to-be-invited-to-a-meeting/
 * @since 2022/1/2 11:19
 */
public class Question5970 {
    public int maximumInvitations(int[] favorite) {
        int length = favorite.length;
        if (length <= 2) {
            return length;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < favorite.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(favorite[i], new ArrayList<>());
            list.add(i);
            map.put(favorite[i], list);
        }
        return 0;
    }
}
