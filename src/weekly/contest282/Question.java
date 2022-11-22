package weekly.contest282;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/contest/weekly-contest-282
 * @since 2022/2/27 10:11
 */
public class Question {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.length() < pref.length()){
                continue;
            }
            if (word.substring(0, pref.length()).equals(pref)){
                res++;
            }
        }
        return res;
    }

    public int minSteps(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>(26);
        HashMap<Character, Integer> tMap = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int res = 0;
        Set<Map.Entry<Character, Integer>> entrySet = sMap.entrySet();
        for (Map.Entry<Character, Integer> next : entrySet) {
            if (tMap.containsKey(next.getKey())) {
                Integer val = tMap.get(next.getKey());
                res += (Math.abs(val - next.getValue()));
                tMap.remove(next.getKey());
            } else {
                res += next.getValue();
            }
            tMap.remove(next.getKey());
        }
        for (Map.Entry<Character, Integer> next : tMap.entrySet()) {
            res += next.getValue();
        }
        return res;
    }


    public long minimumTime(int[] time, int totalTrips) {
        long res = 0;
        Arrays.sort(time);
        for (int i = 0; i < time.length; i++) {

        }
        return res;
    }

//    public long divide(int left, int right, int[] time, int totalTrips){
//        long count = 0;
//        if (left <= right){
//            int mid = (left + right) >> 1;
//            for (int i = 0; i <= mid; i++) {
//                count += mid / time[i];
//        }
//        if (count < totalTrips){
//            if (left == right){
//
//            }
//        }
//        }
//    }
}
