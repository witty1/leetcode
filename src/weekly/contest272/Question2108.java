package weekly.contest272;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/22 14:48
 * @description: https://leetcode-cn.com/problems/find-first-palindromic-string-in-the-array/
 */
public class Question2108 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            int i = 0, j = word.toCharArray().length - 1;
            for (; i < j ; ) {
                if (word.charAt(i) != word.charAt(j)){
                    break;
                }
                i++;
                j--;
            }
            if (i >= j){
                return word;
            }
        }
        return "";
    }

    public String firstPalindrome1(String[] words) {
        for (String word : words) {
            int i = 0, j = word.toCharArray().length - 1;
            while (i < j){
                if (word.charAt(i) != word.charAt(j)){
                    break;
                }
                i++;
                j--;
            }

            if (i >= j){
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        new Question2108().firstPalindrome(new String[]{"pp"});
    }

}
