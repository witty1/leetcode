package weekly.contest279;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/smallest-value-of-the-rearranged-number/
 * @since 2022/2/7 17:10
 */
public class Question2165 {
    public long smallestNumber(long num) {
        if (-10 < num && num < 10){
            return num;
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        int count = 0;

        ArrayList<Integer> list = new ArrayList<>();
        long res = 0;
        while (num != 0) {
            int e = (int) (num % 10);
            if (e == 0) {
                count++;
            } else {
                list.add(e);
            }
            num /= 10;
        }
        Integer[] digits = list.toArray(new Integer[list.size()]);
        Arrays.sort(digits);
        if (negative) {
            int i = digits.length - 1;
            while (i >= 0) {
                res += digits[i--];
                res *= 10;
            }
            res /= 10;
            while (count > 0){
                res *= 10;
                count--;
            }
            res = Math.negateExact(res);
        } else {
            int i = 0;
            res += digits[i++];
            while (count > 0){
                res *= 10;
                count--;
            }
            while (i < digits.length) {
                res *= 10;
                res += digits[i++];

            }
        }
        return res;
    }

    public long smallestNumber1(long num){
        if (num == 0){
            return num;
        }
        ArrayList<Integer> list = new ArrayList<>();
        boolean negative = num < 0;
        num = Math.abs(num);
        while (num > 0){
            list.add((int) (num % 10));
            num /= 10;
        }
        Integer[] arr = list.toArray(new Integer[0]);
        Arrays.sort(arr);
        long res = 0;
        if (negative){
            for (int i = arr.length - 1; i >= 0; i--) {
                res = res * 10 + arr[i];
            }
            res = Math.negateExact(res);
        }else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0){
                    int tmp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = tmp;
                    break;
                }
            }
            for (Integer integer : arr) {
                res = res * 10 + integer;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Question2165().smallestNumber(0);
    }
}
