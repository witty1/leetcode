package weekly;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-327
 * @since 2023/1/8 10:28
 */
public class Weekly327 {

    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }

    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
        while (k-- > 0) {
            Integer poll = queue.poll();
            ans += poll;
            queue.add((int) Math.ceil(poll * 1.0 / 3));
        }
        return ans;
    }


    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        ArrayList<Integer> ove1IdxList = new ArrayList<>();
        ArrayList<Integer> ove2IdxList = new ArrayList<>();
        for (int i = 0, j = 0; i < word1.length() || j < word2.length(); i++, j++) {
            if (i < word1.length()) {
                char c = word1.charAt(i);
                cnt1[c - 'a']++;
            }
            if (j < word2.length()) {
                char c = word2.charAt(j);
                cnt2[c - 'a']++;
            }
        }
        int num1 = 0;
        int num2 = 0;
        boolean ove1 = false;

        boolean ove2 = false;

        for (int i = 0; i < cnt1.length; i++) {
            if (cnt1[i] > 0) {
                num1++;
                if (cnt1[i] > 1) {
                    ove1 = true;
                    ove1IdxList.add(i);
                }
            }
            if (cnt2[i] > 0) {
                num2++;
                if (cnt2[i] > 1) {
                    ove2 = true;
                    ove2IdxList.add(i);
                }
            }
        }
        if (Math.abs(num1 - num2) > 2) {
            return false;
        }
        int dif = num1 - num2;
        if (dif == 0) {
            if (ove1 && ove2) {
                return true;
            }
            return num1 > 1 && num2 > 1;
        }
        for (int i = 0; i < cnt1.length; i++) {
            if (cnt1[i] == 0 && cnt2[i] == 0) {
                continue;
            }
            if (dif > 0) {
                if (dif == 1) {
                    if (cnt1[i] > 1 && cnt2[i] == 0 && ove2) {
                        for (Integer integer : ove2IdxList) {
                            if (cnt1[integer] > 0) {
                                return true;
                            }
                        }
                    }else if (cnt1[i] == 1 && ove2){
                        for (int j = 0; j < cnt2.length; j++) {
                            if (cnt2[j] == 1 && cnt1[j] > 0){
                                return true;
                            }
                        }
                    }
                } else {
                    if (cnt1[i] == 1 && cnt2[i] == 0 && ove2) {
                        for (Integer integer : ove2IdxList) {
                            if (cnt2[integer] == 0) {
                                return true;
                            }
                        }

                    }
                }
            } else {
                if (dif == -1) {
                    if (cnt2[i] > 1 && cnt1[i] == 0 && ove1) {
                        for (Integer integer : ove1IdxList) {
                            if (cnt2[integer] > 0) {
                                return true;
                            }
                        }
                    }else if (cnt2[i] == 1 && ove1){
                        for (int j = 0; j < cnt1.length; j++) {
                            if (cnt1[j] == 1 && cnt2[j] > 0){
                                return true;
                            }
                        }
                    }
                } else {
                    if (cnt2[i] == 1 && cnt1[i] == 0 && ove1) {
                        for (Integer integer : ove1IdxList) {
                            if (cnt1[integer] == 0) {
                                return true;
                            }
                        }

                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        //abc
        //abee
        Weekly327 weekly327 = new Weekly327();
//        System.out.println(weekly327.maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
//        System.out.println(weekly327.isItPossible("aa", "b"));
//        System.out.println(weekly327.isItPossible("aa", "bcd"));
//        System.out.println(weekly327.isItPossible("aa", "bbcc")); //false
        boolean itPossible = weekly327.isItPossible("aab", "bccd");//true
//        assert itPossible;
        itPossible = weekly327.isItPossible("az", "a");//true
        assert itPossible;
         itPossible = weekly327.isItPossible("ab", "abcc");
        assert !itPossible;

        String str = "";
        String[] split = str.split(",");
        System.out.println(split.length);
        System.out.println(split);
//        System.out.println(weekly327.isItPossible("abcc", "aab"));//true
    }
}
