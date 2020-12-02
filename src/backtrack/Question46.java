package backtrack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/11/29
 * @Time: 19:30
 * @Description: https://leetcode-cn.com/problems/permutations/
 */
public class Question46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0){
            return ans;
        }
        boolean[] used = new boolean[nums.length];
        find(0,nums,used,new ArrayList<>(),ans);

        return ans;
    }

    public void find(int depth,int[] nums,boolean[] used,List<Integer> res,List<List<Integer>> ans){
        if (depth == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                res.add(nums[i]);
                used[i] = true;
                find(depth + 1, nums, used, res, ans);
                used[i] = false;
                res.remove(res.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Question46 solution = new Question46();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
