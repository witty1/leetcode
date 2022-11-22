package weekly.contest274;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/2 10:45
 */
public class Question5967 {
    public boolean checkString(String s) {
        boolean flag = false;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (flag && s.charAt(i) == 'a'){
                return false;
            }
            if (s.charAt(i) == 'b'){
                flag = true;
            }
        }
        return true;
    }
}
