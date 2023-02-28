package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/minimum-sideway-jumps/
 * @since 2023/1/21 13:57
 */
public class Question1824 {


    public int minSideJumps(int[] obstacles) {
        int[] roads = new int[]{1, 0, 1};

        for (int i = 1; i < obstacles.length; i++) {
            int minCnt = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] - 1 == j){
                    roads[j] = Integer.MAX_VALUE;
                }else {
                    minCnt = Math.min(minCnt, roads[j]);
                }
            }
            for (int j = 0;j < 3; j++){
                if (j == obstacles[i] - 1){
                    continue;
                }
                roads[j] = Math.min(minCnt + 1, roads[j]);
            }
        }
        return Math.min(Math.min(roads[0], roads[1]), roads[2]);
    }



    public static void main(String[] args) {
        Question1824 question1824 = new Question1824();
        System.out.println(question1824.minSideJumps(new int[]{0, 1, 2, 3, 0}));
//        System.out.println(question1824.minSideJumps(new int[]{0,2,2,1,0,3,0,3,0,1,0}));
    }
}
