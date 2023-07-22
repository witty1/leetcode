package weekly;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-344
 * @since 2023/5/7 10:30
 */
public class weekly344 {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int[] cnt = new int[51];
            int pre = 0;
            for (int j = 0; j <= i; j++) {
                if (cnt[nums[j]] == 0) {
                    pre++;
                    cnt[nums[j]]++;
                }
            }
            cnt = new int[51];
            int suf = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (cnt[nums[j]] == 0) {
                    suf++;
                    cnt[nums[j]]++;
                }
            }
            res[i] = pre - suf;
        }
        return res;
    }


    static class FrequencyTracker {
        HashMap<Integer, Integer> map;
        int[] frequency;

        public FrequencyTracker() {
            map = new HashMap<>();
            frequency = new int[100001];
        }

        public void add(int number) {
            Integer cnt = map.getOrDefault(number, 0);
            if (cnt != 0) {
                frequency[cnt]--;
            }
            frequency[++cnt]++;
            map.put(number, cnt);
        }

        public void deleteOne(int number) {
            Integer integer = map.get(number);
            if (integer != null) {
                frequency[integer--]--;
                if (integer == 0) {
                    map.remove(number);
                } else {
                    frequency[integer]++;
                    map.put(number, integer);
                }
            }
        }

        public boolean hasFrequency(int frequency) {
            return this.frequency[frequency] != 0;
        }


    }

    public int[] colorTheArray(int n, int[][] queries) {
        int[] blocks = new int[n], ans = new int[queries.length];
        int equalCnt = 0;
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>(queries.length);
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0], color = queries[i][1];
            int lowIdx = index - 1, highIdx = index + 1;
            if (blocks[index] != 0) {
                TreeSet<Integer> set = map.getOrDefault(blocks[index], new TreeSet<>());
                Integer lower = set.lower(index);
                Integer higher = set.higher(index);
                if (Objects.equals(lower, lowIdx)) {
                    equalCnt--;
                }
                if (Objects.equals(higher, highIdx)) {
                    equalCnt--;
                }
                set.remove(index);
            }
            TreeSet<Integer> set = map.getOrDefault(color, new TreeSet<>());
            blocks[index] = color;
            set.add(index);
            if (set.size() != 1) {
                Integer lower = set.lower(index);
                Integer higher = set.higher(index);
                if (Objects.equals(lower, lowIdx)) {
                    equalCnt++;
                }
                if (Objects.equals(higher, highIdx)) {
                    equalCnt++;
                }
            } else {
                map.put(color, set);
            }
            ans[i] = equalCnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(1);
        System.out.println(frequencyTracker.hasFrequency(1));
    }
}
