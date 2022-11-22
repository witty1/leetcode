package weekly.contest281;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/2/20 10:29
 */
public class Question {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int j = i;
            int temp = 0;
            while (j > 0){
                temp += j %10;
                j /= 10;
            }
            if((temp & 1) == 0){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Question().countEven(30));
    }
}
