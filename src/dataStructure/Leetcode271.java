package dataStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/7/7
 * @Time: 9:53
 * @Description: No Description
 */
public class Leetcode271 {

    public boolean containsDuplicate(int[] nums) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, null);
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        final HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
