
package weekly.contest268;

/**
 * TODO
 *
 * @author zhengcp25979
 * @version V2.1
 * @description: https://leetcode-cn.com/contest/weekly-contest-268/problems/watering-plants/
 * @since 2021/11/21 10:36
 */
public class Question5201 {

    public int wateringPlants(int[] plants, int capacity) {

        int step = 0;
        int curCapacity = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (curCapacity < plants[i]){
                step += i << 1;
                curCapacity = capacity;
            }
            step++;
            curCapacity -= plants[i];
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Question5201().wateringPlants(new int[]{7,7,7,7,7,7,7}, 8));
    }

}
