package weekly.contest273;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/contest/weekly-contest-273/problems/intervals-between-identical-elements/
 * @since 2021/12/26 11:04
 */
public class Question5965 {



    public long[] getDistances(int[] arr) {
        ArrayList<Integer> list;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            list = map.getOrDefault(temp, new ArrayList<Integer>());
            list.add(i);
            map.put(temp, list);
        }

        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            long ans = 0;
            if (map.containsKey(arr[i])) {
                list = map.get(arr[i]);
                for (int j = 0; j < list.size(); j++) {
                    int end = list.size() - 1;
                    if (j == 0) {
                        for (int n = 1; n < list.size(); n++) {
                            ans += list.get(n) - i;
                        }
                        result[i] = ans;
                    } else {
                        result[list.get(j)] = result[list.get(j - 1)] + (2 * j - end - 1) * (list.get(j) - list.get(j - 1));

                    }


                }
                map.remove(arr[i]);
            }

        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question5965().getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
    }
}
