package weekly;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-326/
 * @since 2023/1/3 14:30
 */
public class Question326 {
    public int countDigits(int num) {

        int ans = 0;
        int temp = num;

        while (num > 0){
            int dig = num % 10;
            if (temp % dig == 0){
                ans++;
            }
            num /= 10;
        }
        return ans;
    }


    public int distinctPrimeFactors(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        double maxSqrt = Math.sqrt(1000);
        for (int i = 2; i <= maxSqrt; i++) {
            double sqrt = Math.sqrt(i);
            int j = 2;
            for (; j <= sqrt; j++) {
                if (i % j == 0){
                    break;
                }
            }
            if (j > sqrt){
                list.add(i);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int i = 0;
            while (i < list.size()){
                Integer divide = list.get(i);
                if (num % divide == 0){
                    num /= divide;
                    set.add(divide);
                }else {
                    i++;
                }
            }
            if (num > 1){
                set.add(num);
            }

        }
        return set.size();
    }


    public int minimumPartition(String s, int k) {
        int temp = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n > k){
                return -1;
            }
            if (temp * 10 + n > k){
                ans++;
                temp = n;
            }else {
                temp *= 10;
                temp += n;

            }
        }

        return ++ans;
    }


    public static void main(String[] args) {
        int limitNum = new Double(Math.ceil(283 / 4)).intValue() + 1;
        System.out.println(limitNum);
        Question326 question326 = new Question326();
//        System.out.println(question326.distinctPrimeFactors(new int[]{2, 4, 3, 7, 10, 6}));
//        System.out.println(question326.distinctPrimeFactors(new int[]{2, 4, 8, 16}));
        System.out.println(question326.minimumPartition("238182", 5));
    }
}
