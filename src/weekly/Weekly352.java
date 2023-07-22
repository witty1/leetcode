package weekly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2023/7/2 11:08
 */
public class Weekly352 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int max = 0;
        boolean find = false;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (find) {
                if (nums[i] > threshold || (i > 0 && nums[i] % 2 == nums[i - 1] % 2)) {
                    int temp = i - l;

                    max = Math.max(max, temp);

                    find = false;

                } else {
                    if (i + 1 >= nums.length) {

                        max = Math.max(max, i - l + 1);
                    }
                    continue;
                }
            }
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {

                find = true;
                l = i;
                if (i + 1 == nums.length) {
                    max = Math.max(1, max);
                }

            }
        }
        return max;
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<Integer> list = eulerSieve(n);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(list.size());
        set.addAll(list);
        HashSet<String> used = new HashSet<>();
        for (Integer num : list) {
            if (num >= n) {
                break;
            }
            int left = n - num;
            if (set.contains(left)) {
                ArrayList<Integer> temp = new ArrayList<>();
                int min = 0;
                int max = 0;
                if (left > num) {
                    min = num;
                    max = left;

                } else {
                    min = left;
                    max = num;
                }
                String s  = min + "_" + max;
                if (!used.contains(s)) {
                    temp.add(min);
                    temp.add(max);
                    ans.add(temp);
                    used.add(s);
                }

            }
        }
        return ans;
    }

    public static List<Integer> eulerSieve(int n) {

        boolean[] isPrime = new boolean[n + 1]; // 标记数组，false表示该下标对应的数是质数
        List<Integer> primes = new ArrayList<>(); // 用动态数组ArrayList存储质数
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) { // 如果该数是质数
                primes.add(i); // 就放入数组中
            }
            // 循环质数的个数次 并且不能超出范围
            for (int j = 0; j < primes.size() && i * primes.get(j) <= n; j++) {
                // i的倍数一定是合数
                isPrime[i * primes.get(j)] = true;
                // 关键 当i能整除的时候就跳出循环
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        // primes列表中存储的就是所有小于等于n的质数
        return primes;
    }

    public static void main(String[] args) {
        Weekly352 weekly352 = new Weekly352();
        System.out.println(weekly352.longestAlternatingSubarray(new int[]{4, 10, 3}, 10));
    }
}
