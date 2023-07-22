package weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-338/
 * @since 2023/3/26 21:39
 */
public class Weekly338 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;
        if (k < numOnes) {
            return k;
        }
        ans += numOnes;
        k -= numOnes;
        k -= numZeros;
        if (k <= 0) {
            return ans;
        }
        ans -= Math.min(numNegOnes, k);
        return ans;
    }


    public boolean primeSubOperation(int[] nums) {
        List<Integer> primeList = init();
        for (int i = 0; i < nums.length; i++) {
            int pre = 0;
            for (Integer integer : primeList) {
                if (integer < nums[i]) {
                    if (i > 0 && nums[i] - integer > nums[i - 1]) {
                        pre = integer;
                    } else if (i == 0) {
                        pre = integer;
                    }
                }else {
                    break;
                }
            }
            nums[i] -= pre;
            if (i > 0 && nums[i] <= nums[i - 1]){
                return false;
            }
        }
        return true;

    }

    private List<Integer> init() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            boolean flag = true;
            int max = (int) Math.sqrt(i);
            for (int j = 2; j <= max; j++) {
                if ((i % j) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }



    public List<Long> minOperations(int[] nums, int[] queries) {
        ArrayList<Long> ans = new ArrayList<>();
        long sum = 0;
        long[] cnt = new long[nums.length + 1];
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            cnt[i] = cnt[i - 1] + nums[i - 1];
            sum += nums[i - 1];
        }

        for (int query : queries) {
            int a = binarySearch(nums, query);
            long temp = 0;
            if (a < nums.length && nums[a] == query) {
                temp = (long) query * (a + 1) - cnt[a + 1];
                temp += sum - cnt[a + 1] - ((long) query * (nums.length - a - 1));
            } else {
                temp = (long) query * a - cnt[a];
                temp += sum - cnt[a] - ((long) query * (nums.length - a));
            }
            ans.add(temp);
        }
        return ans;
    }

    public int binarySearch(int[] nums, int target){
        int l = 0, r = nums.length;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            }else if (nums[mid] > target){
                r = mid;
            }else {
                return mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Weekly338 weekly338 = new Weekly338();
        System.out.println(weekly338.minOperations(new int[]{ Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 8}, new int[]{ 1, 5}));
//        long ans = (long) Integer.MAX_VALUE * 2;
//        System.out.println(ans);
    }
}
