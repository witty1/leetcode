package weekly.contest284;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/3/13 10:28
 */
public class Question {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> keyIndex = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndex.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (Integer index : keyIndex) {
                if (Math.abs(i - index) <= k) {
                    if (!set.contains(i)) {
                        set.add(i);
                        list.add(i);
                    }
                }
            }
        }

        return list;
    }


    //6
    //[[0,2,0,5],[0,1,1,1],[3,0,3,3],[4,4,4,4],[2,1,2,4]]
    //[[0,2],[0,3],[0,4],[2,0],[2,1],[2,2],[2,5],[3,0],[3,1],[3,3],[3,4],[4,0],[4,3],[4,5],[5,0],[5,1],[5,2],[5,4],[5,5]]
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] grid = new boolean[n][n];
        int res = 0;
        for (int[] ints : dig) {
            grid[ints[0]][ints[1]] = true;
        }
        for (int[] artifact : artifacts) {
            boolean expose = true;
            for (int i = artifact[0]; i < artifact[2] && expose; i++) {
                for (int j = artifact[1]; j < artifact[3] && expose; j++) {
                    expose = grid[i][j];
                }
            }
            if (expose){
                res++;
            }
        }

        return res;
    }


    public int maximumTop(int[] nums, int k) {
        int max = -1;
        int length = nums.length;
        int temp = k;

        if (k >= length) {
            for (int num : nums) {
                max = Math.max(num, max);
            }
            k %= length;
            if (length == 1 && k == 0) {
                return (temp & 1) == 0 ? nums[0] : -1;
            }else if (temp == length){ //判断恰好相等的情况
                if (max != nums[length - 1]){
                    return max;
                }
                max = 0;
                for (int i = 0; i < nums.length - 1; i++) {
                    max = Math.max(nums[i], max);
                }
                return max;
            }
            return max;
        }

        int index = 0;
        max = nums[0];
        int remove = 0;
        while (k >= 1){
            if (k == 1){
                if (remove == 0){
                    return nums[1];
                }
                if (max < nums[++index]){
                    max = nums[index];
                }
                break;
            }
            max = Math.max(max, nums[index++]);
            k--;
            remove++;
        }
        return max;
    }

}
