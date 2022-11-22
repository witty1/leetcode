package weekly.autox2023;

import javax.management.openmbean.CompositeData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/8/31 16:12
 */
public class Question2023 {
    public int getLengthOfWaterfallFlow(int num, int[] block) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(num);
        for (int i : block) {
            if (queue.size() < num) {
                queue.add(i);
            } else {
                Integer poll = queue.poll();
                queue.add(poll + i);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer integer : queue) {
            max = Math.max(integer, max);
        }
        return max;
    }

    public double[] honeyQuotes(int[][] handle) {
        ArrayList<Double> list = new ArrayList<>();
        int[] num = new int[101];
        int count = 0, sum = 0;
        for (int[] arrs : handle) {
            switch (arrs[0]) {
                case 1:
                    num[arrs[1]]++;
                    sum += arrs[1];
                    count++;
                    break;
                case 2:
                    num[arrs[1]]--;
                    sum -= arrs[1];
                    count--;
                    break;
                case 3:
                    if (count == 0) {
                        list.add(-1d);
                    } else {
                        list.add(((double) sum / count));
                    }
                    break;
                case 4:
                    if (count != 0) {
                        double avg = (double) sum / count;
                        double square = 0;
                        int curCount = 0;
                        for (int i = 0; i < num.length && curCount < count; i++) {
                            if (num[i] > 0) {
                                curCount += num[i];
                                double pow = Math.pow((i - avg), 2);
                                square += pow * num[i];
                            }
                        }
                        square = square / count;
                        list.add(square);
                    } else {
                        list.add(-1d);
                    }
                    break;
            }
        }
        double[] ans = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * days = [1,4,5]
     * tickets = [[1,4],[5,6],[2,5]]
     *
     * @param days
     * @param tickets
     * @return
     */
    public long minCostToTravelOnDays(int[] days, int[][] tickets) {
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ticket : tickets) {
            Integer value = map.getOrDefault(ticket[0], Integer.MAX_VALUE);
            map.put(ticket[0], Math.min(value, ticket[1]));
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt((ToIntFunction<Map.Entry<Integer, Integer>>) Map.Entry::getValue)
                        .thenComparingInt(Map.Entry::getKey))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        //1 <= days[i] < days[i+1] <= 10^9
        int[][] table = new int[tickets.length][days.length];
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        int idx = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            idx++;
        }

        return res;
    }

    public static void main(String[] args) {
        Question2023 question2023 = new Question2023();
//        question2023.getLengthOfWaterfallFlow(5, new int[]{8,2,6,7,1});
//        int[][] nums = new int[][]{{1,1},{1,2},{1,3},{1,2},{3},{4},{2,1},{2,2},{2,3},{3},{4}};
        int[][] nums = new int[][]{{4}, {1, 76}, {1, 89}, {4}, {2, 89}, {1, 62}, {1, 38}, {3}, {4}};
        question2023.honeyQuotes(nums);
    }
}
