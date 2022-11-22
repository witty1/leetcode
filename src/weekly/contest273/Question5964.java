package weekly.contest273;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/26 10:49
 * @description: https://leetcode-cn.com/contest/weekly-contest-273/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
 */
public class Question5964 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        int i = 0, j = 0;

        for (int i1 = 0; i1 < s.length(); i1++) {
            int x = startPos[0], y = startPos[1];
            int count = 0;
            for (int k = i1; k < s.length(); k++) {
                switch (s.charAt(k)) {
                    case 'L':
                        y -= 1;
                        break;
                    case 'R':
                        y +=1;
                        break;
                    case 'U':
                        x -= 1;
                        break;
                    case 'D':
                        x += 1;
                        break;
                    default:
                        break;
                }
                if (x >= n || y >=n || x <0 || y <0){
                    break;
                }
                count++;
            }
           ans[i1] = count;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question5964().executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
    }
}
