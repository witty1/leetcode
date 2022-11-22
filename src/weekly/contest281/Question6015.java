package weekly.contest281;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/2/20 10:51
 */
public class Question6015 {
    public long coutPairs(int[] nums, int k) {
        long res = 0;
        ArrayList<Integer> minList = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                minList.add(nums[i]);
            } else {
                maxList.add(nums[i]);
            }
        }
        if (maxList.size() == 0) {
            return res;
        }
        minList.sort(Comparator.naturalOrder());
        maxList.sort(Comparator.naturalOrder());
        int sep = 0, j = 1;
        int minSize = minList.size();
        while (j < minSize && minList.get(0) * minList.get(j) < k) {
            j++;
        }
        if (j < minSize) {
            sep = j;
        }
        if (sep > 0) {
            for (int i = 0; i < minSize; i++) {
                for (j = sep; j < minSize && j != i; j++) {
                    if ((minList.get(i) % k * minList.get(j) % k) % k == 0) {
                        res++;
                    }
                }
            }
        }
        int idx = 0;
        for (int i = 0; i < maxList.size(); i++) {
            for (int l = 0; l < maxList.size() && l != i; l++) {
                if ((maxList.get(i) % k * maxList.get(l) % k) % k == 0) {
                    res++;
                }
            }
        }
        for (int i = 0; i < minList.size(); i++) {
            for (j = 0; j < maxList.size(); j++) {
                if ((minList.get(i) % k * maxList.get(j) % k) % k == 0) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Question6015().coutPairs(new int[]{1,2,3,4,5}, 2);
    }
}
