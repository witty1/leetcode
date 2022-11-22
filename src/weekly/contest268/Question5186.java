
package weekly.contest268;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979
 * @version V2.1
 * @description: https://leetcode-cn.com/contest/weekly-contest-268/problems/range-frequency-queries/
 * @since 2021/11/21 10:36
 */
public class Question5186 {
    static class RangeFreqQuery {
        List<List<Integer>> numberList;


        public RangeFreqQuery(int[] arr) {
            numberList = new ArrayList<>(10000);
            for (int i = 0; i <= 10000; i++) {
                numberList.add(new ArrayList<>());
            }
            for (int i = 0; i < arr.length; i++) {
                numberList.get(arr[i]).add(i);
            }

        }


        public int query(int left, int right, int value) {
            List<Integer> list = numberList.get(value);
            if (list.size() == 0) {
                return 0;
            }
            int l = binarySearch(list, 0, list.size() - 1, left);
            if (list.get(l) > right || list.get(l) < left) {
                return 0;
            }
            int r = binarySearch(list, l, list.size() - 1, right);
            if (list.get(r) > right) {
                r--;
            }

            return r - l + 1;
        }

        public int binarySearch(List<Integer> list, int left, int right, int target) {
            while (left < right) {
                int mid = (right - left) / 2 + left;

                if (list.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;

        }


    }

    public static void main(String[] args) {
//        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{8, 8, 6, 7, 5, 7, 7, 8, 3, 6, 3, 4, 6, 6, 5, 5, 4, 4, 7, 7});
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
//        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{1, 1, 1, 2, 2});
        rangeFreqQuery.query(0, 11, 33);
    }
}
