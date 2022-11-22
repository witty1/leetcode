package weekly.contest308;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-308/
 * @since 2022/9/1 14:11
 */
public class Question308 {
//    public int[] answerQueries(int[] nums, int[] queries) {
//        int[] res = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            int len = 0;
//            int count = 0;
//            int cur = 0;
//            int max = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (count + nums[j] <= queries[i]) {
//                    count += nums[j];
//                    len++;
//                    max = Math.max(max, len);
//                } else {
//                    while (count + nums[j] > queries[i] && cur <= j){
//                        if (count != 0){
//                            count -= nums[cur];
//
//                            len--;
//                        }
//                        cur++;
//                    }
//                    if (count + nums[j] <= queries[i]){
//                        len++;
//                        count += nums[j];
//                    }
//                }
//            }
//            res[i] = max;
//        }
//
//        return res;
//    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length && queries[i] >= nums[j]; j++) {
                count++;
            }
            res[i] = count;
        }

        return res;
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int curG = -1;
        int curP = -1;
        int curM = -1;
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }
        for (int i = 0; i < garbage.length; i++) {
            String temp = garbage[i];
            for (int j = 0; j < temp.length(); j++) {
                switch (temp.charAt(j)) {
                    case 'P':
                        curP = i;
                        break;
                    case 'M':
                        curM = i;
                        break;
                    case 'G':
                        curG = i;
                        break;
                }
            }
            ans += temp.length();
        }
        if (curP > 0){
            ans += travel[curP - 1];
        }
        if (curG > 0){
            ans += travel[curG - 1];
        }
        if (curM > 0){
            ans += travel[curM - 1];
        }
        return ans;
    }


    public static void main(String[] args) {
        Question308 question308 = new Question308();
//        question308.answerQueries(new int[]{736411, 184882, 914641, 37925, 214915}, new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450});
        question308.garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2,4,3});
    }
}
