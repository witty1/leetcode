package weekly.contest275;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/9 10:53
 */
public class Question5978 {
    public int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        String[] tempTarget = new String[targetWords.length];
        HashSet<String > set = new HashSet<>();
        for (int i = 0; i < targetWords.length; i++) {
            char[] a = targetWords[i].toCharArray();
            Arrays.sort(a);
            tempTarget[i] = new String(a);
        }
        String[] tempStart = new String[startWords.length];
        for (int i = 0; i < startWords.length; i++) {
            char[] a = startWords[i].toCharArray();
            Arrays.sort(a);
            tempStart[i] = new String(a);
        }
        for (int i = 0; i < tempTarget.length; i++) {
            for (int j = 0; j < tempStart.length; j++) {
                String t = tempTarget[i];
                String s = tempStart[j];
                if (t.length() != (s.length() + 1)){
                    continue;
                }
                int count = 0, idxT = 0, idxS = 0;

                while (idxT < t.length() && idxS != s.length()){
                    if (count > 1){
                        break;
                    }
                    if (t.charAt(idxT++) != s.charAt(idxS)){
                        count++;
                    }else {
                        idxS++;
                    }
                }
                if (count <= 1){
                    set.add(t);

                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
//        System.out.println(new Question5978().wordCount(new String[]{"ab", "a"}, new String[]{"abc", "abcd"}));
        System.out.println(new Question5978().wordCount(new String[]{"g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"}, new String[]{"r","am","jg","umhjo","fov","lujy","b","uz","y"}));
    }
}
