package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2023/3/6 20:24
 */
public class Question1653 {
    //aababbab
    public int minimumDeletions(String s) {

        int rightA = 0;
        int leftB = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                rightA++;
            }
        }
        int res = rightA;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a'){
                rightA--;
            }else {
                leftB++;
            }
            res = Math.min(res, leftB + rightA);
        }
        return res;
    }

    public static void main(String[] args) {
        Question1653 question1653 = new Question1653();
        question1653.minimumDeletions("aababbab");
    }
}
