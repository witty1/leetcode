package weekly.contest276;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/16 11:18
 */
public class Question5982 {
    public long mostPoints(int[][] questions) {
        ArrayList<Integer> list = new ArrayList<>();
        int[][] table = new int[questions.length][questions.length];
        byte[][] used = new byte[questions.length][questions.length];
        int skip = 0;
        long point = 0L;
        for (int i = 0; i < questions.length; i++) {
            if (skip == 0) {
                point += questions[i][0];
                table[0][i] = questions[i][0];
                skip = questions[i][1];
            } else {
                used[0][i] = 1;
                skip--;
            }

        }
        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                int back = j;
                while (used[i - 1][j] != 1 && j<table[i].length) {
                    j++;
                }
                if (j >= table[i].length){
                    break;
                }
                if (table[i - 1][j]==0){

                }
            }
        }


        return point;
    }

    public static void main(String[] args) {
        System.out.println(new Question5982().mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}));
    }
}
