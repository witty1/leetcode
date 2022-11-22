package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 * @since 2022/9/19 8:49
 */
public class Question1636 {

    public static int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer val = map.getOrDefault(num, 0);
            map.put(num, ++val);
        }
//        return Arrays.stream(nums)
//                .boxed()
//                .sorted((o1, o2) -> {
//                    Integer val1 = map.get(o1);
//                    Integer val2 = map.get(o2);
//                    if (val1.compareTo(val2) != 0) {
//                        return val1 - val2;
//                    }
//                    return o2 - o1;
//                })
//                .mapToInt(Integer::intValue)
//                .toArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((o1, o2) -> {
            Integer val1 = map.get(o1);
            Integer val2 = map.get(o2);
            if (val1.compareTo(val2) != 0) {
                return val1 - val2;
            }
            return o2 - o1;
        });
        int[] ans = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static int[] frequencySort1(int[] nums) {
        int[] cnt = new int[201];
        for (int num : nums) {
            cnt[num + 100]++;
        }
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1].compareTo(o2[1]) != 0) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                queue.add(new Integer[]{i - 100, cnt[i]});
            }
        }
        int[] ans = new int[nums.length];
        int i = 0;
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            for (int j = 0; j < poll[1]; j++) {
                ans[i++] = poll[0];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        frequencySort(new int[]{1, 1, 2, 2, 2, 3});
    }
}
