package weekly.contest287;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/contest/weekly-contest-287/
 * @since 2022/4/10 9:44
 */
public class Question287 {
    public int convertTime(String current, String correct) {
        String[] curSplit = current.split(":");
        int curHour = Integer.parseInt(curSplit[0]);
        int curMin = Integer.parseInt(curSplit[1]);
        String[] corSplit = correct.split(":");
        int corHour = Integer.parseInt(corSplit[0]);
        int corMin = Integer.parseInt(corSplit[1]);
        int res = 0;
        int subMin = 0;
        if (curMin > corMin) {
            subMin = 60 + corMin - curMin;
            curHour++;
        } else if (curMin < corMin) {
            subMin = corMin - curMin;
        }
        if (subMin > 0) {
            res += subMin / 15;
            subMin %= 15;
            res += subMin / 5;
            subMin %= 5;
            res += subMin;
        }
        int subHour = corHour - curHour;
        return res + subHour;
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        ArrayList<List<Integer>> res = new ArrayList<>(matches.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            Integer val = map.getOrDefault(match[1], 0);
            map.put(match[1], ++val);
            map.put(match[0], map.getOrDefault(match[0], 0));
        }
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> zero = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                zero.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                one.add(entry.getKey());
            }
        }
        res.add(zero.stream()
                .sorted()
                .collect(Collectors.toList()));
        res.add(one.stream()
                .sorted()
                .collect(Collectors.toList()));
        return res;
    }

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        int res = 0, left = 1;
        int right = (int) (sum / k);
        while (left <= right){
            int mid = (left + right) >> 1;
            if (check(k,mid, candies)){
                res = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return res;
    }

    private boolean check(long k, int i,  int[] candies){
        long res = 0;
        for (int candy : candies) {
            res += candy / i;
        }
        return res >= k;
    }

    public static void main(String[] args) {
        new Question287().maximumCandies(new int[]{5,8,6}, 3);
    }
}
