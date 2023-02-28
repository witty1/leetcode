package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 * @since 2023/1/3 10:16
 */
public class Question2042 {
    public boolean areNumbersAscending(String s) {
        String[] strs = s.split(" ");
        int pre = 0;
        for (String str : strs) {
            int num = str.charAt(0) - '0';

            if (num >= 0 && num <= 9){
                for (int i = 1; i < str.length(); i++) {
                    num *= 10;
                    num += str.charAt(i);
                }
                if (num <= pre){
                    return false;
                }
                pre = num;
            }
        }
        return true;
    }
}
