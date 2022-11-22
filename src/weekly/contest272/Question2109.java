package weekly.contest272;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/22 14:59
 * @description: https://leetcode-cn.com/problems/adding-spaces-to-a-string/
 */
public class Question2109 {
    public String addSpaces(String s, int[] spaces) {
        char[] str = new char[s.length() + spaces.length];
        int j = 0;
        for (int i = 0,k = 0; k < s.length(); i++) {
            if (j < spaces.length && k == spaces[j]){
                str[i] = ' ';
                j++;
            }else {
                str[i] = s.charAt(k++);
            }

        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(new Question2109().addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }
}
