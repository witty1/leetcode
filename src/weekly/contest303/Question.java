package weekly.contest303;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-303/
 * @since 2022/7/26 15:12
 */
public class Question {
    public char repeatedCharacter(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (++count[index] == 2) {
                return c;
            }
        }
        return ' ';
    }

    public int equalPairs(int[][] grid) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int[] ints : grid) {
            String s = Arrays.toString(ints);
            Integer value = map.getOrDefault(s, 0);
            map.put(s, ++value);
        }

        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][j]);
                sb.append(',');
            }
           count+=map.getOrDefault(sb.toString(), 0);
        }
        return count;
    }

    class FoodRatings {
        HashMap<String, Integer> foodMap;
        HashMap<String, String> foodAndCuisinMap;
        HashMap<String, List<String>> cuisinMap;
        HashMap<String, String> ratingMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodMap = new HashMap<>(foods.length);
            cuisinMap = new HashMap<>(cuisines.length);
            foodAndCuisinMap = new HashMap<>(foods.length);
            ratingMap = new HashMap<>(cuisines.length);
            for (int i = 0; i < foods.length; i++) {
                foodMap.put(foods[i], ratings[i]);
                String name = ratingMap.getOrDefault(cuisines[i], null);
                if (name == null){
                    ratingMap.put(cuisines[i], foods[i]);
                }else {
                    if (foodMap.get(name) < ratings[i]){
//                        ratingMap.put()
                    }
                }
                foodAndCuisinMap.put(foods[i], cuisines[i]);
            }
        }

        public void changeRating(String food, int newRating) {

        }

        public String highestRated(String cuisine) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question().equalPairs(new int[][]{{11, 1}, {1, 11}}));
    }
}
