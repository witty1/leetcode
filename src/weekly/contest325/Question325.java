package weekly.contest325;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-325/
 * @since 2022/12/25 10:28
 */
public class Question325 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                list.add(i);
            }
        }
        for (Integer integer : list) {
            int dis = Math.min(Math.abs(integer - startIndex), startIndex + words.length - integer);
            dis = Math.min(dis, words.length - startIndex + integer);
            ans = Math.min(dis, ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int closetTarget1(String[] words, String target, int startIndex) {
        int len = words.length;
        for (int i = startIndex, j = startIndex, step = 0; step < len; i = ++i % len, j = (--j + len) % len, ++step) {
            if (words[i].equals(target) || words[j].equals(target)) {
                return step;
            }
        }
        return -1;
    }


    public int takeCharacters(String s, int k) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[3];
        int length = chars.length;
        int j = length;
        while (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            if (j == 0) {
                return -1;
            }
            cnt[chars[--j] - 'a']++;
        }
        int ans = length - j;
        for (int i = 0; i < length; i++) {
            cnt[chars[i] - 'a']++;
            while (j < length && cnt[chars[j] - 'a'] > k) {
                cnt[chars[j] - 'a']--;
                j++;
            }
            ans = Math.min(ans, i + 1 + length - j);
            if (j == length) {
                break;
            }
        }
        return ans;
    }

    public boolean check(int m, int[] price, int k) {
        int cnt = 0;
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < price.length && cnt < k; i++) {
            if (price[i] >= pre + m) {
                cnt++;
                pre = price[i];
            }
        }
        return cnt >= k;
    }


    public int maximumTastiness(int[] price, int k) {
        int max = 0;
        Arrays.sort(price);
        int l = 0, r = price[price.length - 1];
        while (l <= r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, price, k)) {
                max = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return max;
    }


    //13,5,1,8,21,2  2, 13, 21 11,19,8
    public static void main(String[] args) {

//        new Question325().closetTarget(new String[]{"hello","i","am","leetcode","hello"}, "hello", 1);
//        new Question325().closetTarget(new String[]{"a","b","leetcode"}, "leetcode", 0);
//        new Question325().closetTarget(new String[]{"hsdqinnoha", "mqhskgeqzr", "zemkwvqrww", "zemkwvqrww", "daljcrktje", "fghofclnwp", "djwdworyka", "cxfpybanhd", "fghofclnwp", "fghofclnwp"}, "zemkwvqrww", 8);
        new Question325().takeCharacters("acba", 1);
//        new Question325().maximumTastiness(new int[]{34,116,83,15,150,56,69,42,26}, 6);
    }
}
