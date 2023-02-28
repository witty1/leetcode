package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2023/2/28 16:55
 */
public class Question2363 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] cnt = new int[1001];
        for (int[] ints : items1) {
            cnt[ints[0]] += ints[1];
        }
        for (int[] ints : items2) {
            cnt[ints[0]] += ints[1];
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0){
                res.add(Arrays.asList(i, cnt[i]));
            }
        }
        return res;
    }



}
