package weekly.contest271;

import java.util.HashMap;
import java.util.HashSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/12 10:31
 */
public class Question5952 {
    public int countPoints(String rings) {
        char[] ring = rings.toCharArray();
        byte[] goal = new byte[1000];
        int res = 0;
        HashMap<Integer, HashSet<Character>> map = new HashMap<>(100);
        //r 0,g,1,b,2
        for (int i = 0; i < ring.length; i += 2) {
            int key = ring[i + 1];
            if (map.containsKey(key)){
                map.get(key).add(ring[i]);

            }else {
                HashSet<Character> set = new HashSet<>();
                set.add(ring[i]);
                map.put(key, set);
            }
            if (map.get(key).size() == 3 && goal[key] != 1){
                res++;
                goal[key] = 1;
            }
        }
        return res;

    }
}
