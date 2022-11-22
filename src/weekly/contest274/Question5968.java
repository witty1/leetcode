package weekly.contest274;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/2 10:48
 * @description: https://leetcode-cn.com/contest/weekly-contest-274/problems/number-of-laser-beams-in-a-bank/
 */
public class Question5968 {
    public int numberOfBeams(String[] bank) {
        int[] count = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1'){
                    count[i]++;
                }
            }
        }
        int res = 0;
        int preRow = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0){
                continue;
            }
            if (preRow == -1){
                preRow = i;
                continue;
            }
            res += count[i] * count[preRow];
            preRow = i;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Question5968().numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
    }
}
