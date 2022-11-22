package weekly.contest278;

import java.util.HashMap;
import java.util.HashSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/30 10:31
 */
public class Question5994 {
    long preHash = 0;

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        for (int i = 0; i < s.length(); i += 1) {
            if (i + k >= s.length()) {
                return "";
            }
            String substring = s.substring(i, i + k);
            if (calculate(substring, power, modulo, hashValue)) {
                return substring;
            }
        }

        return "";
    }

    /**
     * "leetcode"
     * 7
     * 20
     * 2
     * 0
     * "xmmhdakfursinye"
     * 96
     * 45
     * 15
     * 21
     * @param str
     * @param power
     * @param modulo
     * @param hashVal
     * @return
     */
    public boolean calculate(String str, int power, int modulo, int hashVal) {
        long strHash = 0;
        for (int i = 0; i < str.length(); i++) {
            strHash = (long) (((str.charAt(i) - 'a' + 1) % modulo) * (Math.pow(power, i) % modulo)) % modulo + strHash;
        }
        System.out.println(strHash % modulo);
        return hashVal == (strHash % modulo);
    }


}
