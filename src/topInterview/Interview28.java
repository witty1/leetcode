package topInterview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/17
 * @Time: 14:08
 * @Description: No Description
 */
public class Interview28 {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int j = 0, temp = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                temp = temp == -1 ? i : temp;
                j++;
                if (j == needle.length()) {
                    return temp;
                }
                continue;
            }
            i = temp == -1 ? i : temp ;
            j = 0;
            temp = -1;
        }
        return j == needle.length() ? temp : -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "pi"));
    }
}
