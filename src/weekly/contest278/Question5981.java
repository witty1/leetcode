package weekly.contest278;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/30 10:35
 * @description: https://leetcode-cn.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/
 */
public class Question5981 {

    public List<Integer> maxScoreIndices(int[] nums) {
        int l = 0, r = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (num == 1) {
                r++;
            }
        }
        int max = r;
        res.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                l++;
            } else if (nums[i] == 1) {
                r--;
            }
            int score = l + r;
            if (max < score) {
                max = score;
                res.clear();
                res.add(i + 1);
            } else if (max == score) {
                res.add(i + 1);
            }

        }

        return res;
    }


//    public List<Integer> maxScoreIndices(int[] nums) {
//        int zero = 0, one = 0;
//        ArrayList<Integer> res = new ArrayList<>();
//        long max = 0;
//        for (int num : nums) {
//            if (num == 0) {
//                zero++;
//            } else {
//                one++;
//            }
//        }
//        if (zero < one) {
//            max = one;
//            res.add(0);
//
//        }
//        int nZero = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int nOne = 0;
//            if (nums[i] == 0){
//                nZero++;
//            }
//            for (int j = nums.length - 1; j > i; j--) {
//                if (nums[j] == 1){
//                    nOne++;
//                }
//            }
//            long score = nZero + nOne;
//            if (score > max){
//                max = score;
//                res.clear();
//                res.add(i + 1);
//            }else if (score == max){
//                res.add(i + 1);
//            }
//        }
//
//        return res;
//    }
    public static void main(String[] args) {
        new Question5981().maxScoreIndices(new int[]{0,0,1,0}).forEach(System.out::println);
    }
}
