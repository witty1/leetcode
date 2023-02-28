package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/description/
 * @since 2022/12/28 19:31
 */
public class Question1750 {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (true) {
            if (left > right) {
                return 0;
            }
            if (arr[left] != arr[right] || left == right) {
                return right - left + 1;
            }
            while (left + 1 <= right && arr[left + 1] == arr[left]) {
                left++;
            }
            while (right - 1 >= left && arr[right - 1] == arr[right]) {
                right--;
            }
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        Question1750 question1750 = new Question1750();
        System.out.println(question1750.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
