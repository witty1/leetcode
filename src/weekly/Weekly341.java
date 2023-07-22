package weekly;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-341
 * @since 2023/4/16 10:25
 */
public class Weekly341 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = 0, max = 0;
        for (int i = 0; i < mat.length; i++) {
            int temp1 = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    temp1++;
                }
            }
            if (temp1 > max) {
                row = i;
                max = temp1;
            }
        }
        return new int[]{row, max};
    }


    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = 0, maxCnt = 0, min = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            int cnt = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    cnt++;
                }
            }
            if (cnt > maxCnt || (cnt == maxCnt && divisor < ans)) {
                ans = divisor;
                maxCnt = cnt;
            }
            min = Math.min(min, divisor);
        }
        return ans == 0 ? min : ans;
    }

    public int addMinimum(String word) {
        char pre = '&';
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a') {
                if (pre == 'a') {
                    cnt += 2;
                } else if (pre == 'b') {
                    cnt++;
                }
                pre = c;
            } else if (c == 'b') {
                if (pre == '&') {
                    cnt++;
                }else if (pre == 'b'){
                    cnt += 2;
                }
                pre = c;
            } else if (c == 'c') {
                if (pre == '&') {
                    cnt += 2;

                } else if (pre == 'a') {
                    cnt++;
                }
                pre = '&';
            }
        }
        char c = word.charAt(word.length() - 1);
        cnt += 'c' - c;
        return cnt;
    }

    public static void main(String[] args) {
        Weekly341 weekly341 = new Weekly341();
        System.out.println(weekly341.addMinimum("aaaabb"));
    }
}
