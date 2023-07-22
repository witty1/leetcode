package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 * @since 2023/3/9 10:33
 */
public class Question2379 {
    public int minimumRecolors(String blocks, int k) {
        int r = 0, white = 0;
        while (r <= k) {
            if (blocks.charAt(r) == 'W') {
                white++;
            }
            r++;
        }
        int min = white;
        for (int l = 0; r < blocks.length(); l++, r++) {
            white -= blocks.charAt(l) == 'W' ? 1 : 0;
            white += blocks.charAt(r) == 'W' ? 1 : 0;
            min = Math.min(min, white);
        }
        return min;
    }

    public static void main(String[] args) {
        Question2379 question2379 = new Question2379();
        System.out.println(question2379.minimumRecolors("WBWBBBW", 2));
    }
}
