package topInterview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/24
 * @Time: 10:34
 * @Description: https://leetcode-cn.com/problems/count-and-say/
 */
public class Interview38 {
    public static String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        }

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            int cur = Character.getNumericValue(s.charAt(0));
            for (int j = 0; j < s.length(); j++) {
                int value = Character.getNumericValue(s.charAt(j));
                if (cur == value) {
                    ++count;
                    if (j+1==s.length()){
                        sb.append(count).append(value);
                    }
                } else {
                    sb.append(count).append(cur);
                    if (j + 1 == s.length()) {
                        sb.append(1).append(value);

                    } else {
                        count = 1;
                        cur = value;
                    }
                }
            }


            s = sb.toString();
        }


        return s;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
