package weekly.contest274;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/2 11:02
 * @description: https://leetcode-cn.com/contest/weekly-contest-274/problems/destroying-asteroids/
 */
public class Question5969 {
    //81583
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long height = mass;
        Arrays.sort(asteroids);
        System.out.println(Arrays.toString(asteroids));
        for (int asteroid : asteroids) {
            if (height >= asteroid){
                height += asteroid;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Question5969().asteroidsDestroyed(10, new int[]{3,9,19,5,21});
    }
}
