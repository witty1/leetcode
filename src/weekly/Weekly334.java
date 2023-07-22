package weekly;

import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-334/
 * @since 2023/3/9 16:31
 */
public class Weekly334 {
    public int[] leftRigthDifference(int[] nums) {
        int[] leftNum = new int[nums.length];
        int[] rightNum = new int[nums.length];
        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            leftNum[i] = leftNum[i - 1] + nums[i - 1];
            rightNum[j] = rightNum[j + 1] + nums[j + 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < leftNum.length; i++) {
            ans[i] = Math.abs(leftNum[i] - rightNum[i]);
        }
        return ans;
    }


    public int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        long cnt = 0L;
        //7    75
        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - '0';
            cnt = cnt * 10 + num;
            if (cnt % m == 0){
                ans[i] = 1;
            }
            cnt = Math.floorMod(cnt, m);
        }
        return ans;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        // 1 2 3 4 5
        for (int j = nums.length + 1 >> 1; j < nums.length; j++) {
            if (2 * nums[i] <= nums[j]){
                ++i;
            }
        }
        return 2 * i;
    }

    public static void main(String[] args) {
        long cnt = 2L * Integer.MAX_VALUE;
        System.out.println(cnt);
        Weekly334 weekly334 = new Weekly334();
        System.out.println(weekly334.maxNumOfMarkedIndices(new int[]{42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40}));
    }
}
