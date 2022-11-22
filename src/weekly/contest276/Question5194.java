package weekly.contest276;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/16 11:03
 */
public class Question5194 {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (maxDoubles != 0 && target != 1) {
            if ((target & 1) == 1) {
                target--;
                count++;
                continue;
            }
            target >>= 1;
            count++;
            maxDoubles--;
        }
        return count + target - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Question5194().minMoves(19, 2));
//        System.out.println(new Question5194().minMoves(5, 0));
    }
}
