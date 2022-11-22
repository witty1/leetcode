package weekly.contest288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/contest/weekly-contest-288
 * @since 2022/4/10 10:25
 *
 */
public class Question288 {
    public int largestInteger(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        int res = 0;
        while (num > 0) {
            int val = num % 10;
            num /= 10;
            if ((val & 1) == 0) {
                even.add(val);
                list.add(0);
            } else {
                odd.add(val);
                list.add(1);
            }
        }
        even = (ArrayList<Integer>) even.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        odd = (ArrayList<Integer>) odd.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Iterator<Integer> evenIte = even.iterator();
        Iterator<Integer> oddIte = odd.iterator();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 0) {
                res += evenIte.next();
            } else {
                res += oddIte.next();
            }
            if (i != 0) {
                res *= 10;
            }

        }

        res /= 10;
        return res;
    }

    public String minimizeResult(String expression) {
        String res = null;
        int pos = expression.indexOf("+");
        int min = Integer.MAX_VALUE;
        for (int left = 0; left < pos; left++) {
            for (int right = pos + 1; right < expression.length(); right++) {
                String s1 = expression.substring(0, left);
                String s2 = expression.substring(left, right + 1);
                String s3 = expression.substring(right + 1);
                int sum = calculate(s1, s2, s3);
                if (sum < min){
                    res = String.format("%s(%s)%s", s1, s2, s3);
                    min = sum;
                }
            }
        }
        return res;
    }

    private int calculate(String s1, String s2, String s3){
        String[] split = s2.split("\\+");
        int sum = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        if (!s1.isEmpty()){
            sum *= Integer.parseInt(s1);
        }
        if (!s3.isEmpty()){
            sum *= Integer.parseInt(s3);
        }
        return sum;
    }

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        long res = 1;
        while (k-- != 0){
            int poll = queue.poll();
            queue.offer(++poll);
        }
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            res = (res * next) % 1_000_000_007;
        }
        return (int) res;
    }

    private int binarySearch(int[] nums, int k) {
        int left = 0, right = nums.length - 1, res = 0;
        int check;
        while (left <= right) {
            int mid = (left + right) >> 1;
            check = check(nums, left, mid, k);
            if (check == 0) {
                return mid;
            } else if (check < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    private int check(int[] nums, int left, int mid, int k) {
        int num = 0;
        for (int i = left; i < mid; i++) {
            num += nums[mid] - nums[i];
        }
        return k - num;
    }

    public static void main(String[] args) {
        Question288 question288 = new Question288();
        System.out.println(question288.minimizeResult("247+38"));
//        System.out.println(question288.maximumProduct(new int[]{6, 3, 3, 2}, 2));
    }
}
