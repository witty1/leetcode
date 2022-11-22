package weekly.contest276;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/16 10:40
 */
public class Question5980 {
    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() < k){
                sb.append(s.charAt(i));
            }else if (sb.length() == k){
                list.add(sb.toString());
                sb = new StringBuilder();
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() != 0){
            while (sb.length()!=k){
                sb.append(fill);
            }

            list.add(sb.toString());
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question5980().divideString("ctoyjrwtngqwt",
                8,
                'n')));
        System.out.println(Arrays.toString(new Question5980().divideString("abcdefghij", 3,'x')));
    }
}
