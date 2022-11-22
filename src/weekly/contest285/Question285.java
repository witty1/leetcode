package weekly.contest285;

import java.util.HashMap;
import java.util.HashSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/contest/weekly-contest-285
 * @since 2022/3/20 10:25
 */
public class Question285 {

    public int countHillValley(int[] nums) {
        int res = 0;
        int length = nums.length;
        if (length <= 2) {
            return res;
        }
        int pre = 0;
        int next;
        for (int i = 1; i < length; i++) {
            while (i < length && nums[pre] == nums[i]) {
                i++;
            }
            if (i >= length) {
                break;
            }
            next = i + 1;
            while (next < length && nums[i] == nums[next]) {
                next++;
            }
            if (next >= length) {
                break;
            }
            if (nums[i] > nums[pre] && nums[i] > nums[next]) {
                res++;
            } else if (nums[i] < nums[pre] && nums[i] < nums[next]) {
                res++;
            }
            pre = i;
            i = next - 1;
        }
        return res;
    }

    public int countCollisions(String directions) {
        char[] array = directions.toCharArray();
        int res = 0;
        int left = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < array.length; i++) {
            char l = array[left];
            char mid = array[i];
            if (l != mid) {
                if (mid == 'L') {
                    if (l == 'R') {
                        set.add(left);
                        set.add(i);
                        res += 2;
                        array[i] = 'S';
                        array[left] = 'S';
                    } else if (l == 'S') {
                        set.add(i);
                        res++;
                        array[i] = 'S';
                    }
                } else if (mid == 'S' && l == 'R') {
                    set.add(left);
                    array[left] = 'S';
                    res++;
                }

            }
            left = i;
        }
        int right = array.length - 1;
        for (int i = array.length - 2; i >= 0; i--) {
            char r = array[right];
            char mid = array[i];
            if (r != mid) {
                if (mid == 'R') {
                    if (r == 'L') {
                        if (!set.contains(i) ) {
                            res ++;
                        }
                        if (!set.contains(right)){
                            res++;
                        }
                        array[right] = 'S';
                        array[i] = 'S';
                    } else if (r == 'S') {
                        if (!set.contains(i)) {
                            res++;
                        }
                        array[i] = 'S';
                    }
                } else if (mid == 'S' && r == 'L') {
                    if (!set.contains(right)) {
                        res++;
                    }

                }

            }
            right = i;
        }
        return res;
    }


    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] res = new int[12];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < aliceArrows.length; i++) {
            map.put(i, aliceArrows[i]);
        }
        int i;

        for (i = 11; i >=0; i--){
            Integer count = map.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Question285 question285 = new Question285();
//        System.out.println(question285.countHillValley(new int[]{8, 2, 5, 7, 7, 2, 10, 3, 6, 2}));
//        System.out.println(question285.countHillValley(new int[]{21, 21, 21, 2, 2, 2, 2, 21, 21, 45}));
        System.out.println(question285.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
}
