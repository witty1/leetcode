package weekly.contest281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/2/20 10:47
 */
public class Question6014 {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        StringBuilder res = new StringBuilder();
        int count = 0;
        Character pre = null;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (list.size() > 0 && !list.get(0).equals(pre)){
                count = 0;
                while (list.size() > 0 && count < repeatLimit){
                    char c = list.get(0);
                    list.remove(0);
                    res.append(c);
                    if (pre == c){
                        count += 1;
                    }else {
                        pre = c;
                        count = 1;
                    }
                }

                i++;

                continue;
            }
            if (pre != null && count >= repeatLimit && array[i] == pre){
                list.add(array[i]);
                continue;
            }
            res.append(array[i]);
            if (pre != null && pre == array[i]){
                count++;
            }else {
                pre = array[i];
                count = 1;
            }
        }
        int size = list.size();
        int idx = 0;
        while (idx < size){
            Character c = list.get(idx);
            if (count < repeatLimit){

                res.append(c);
                if (pre.equals(c)){
                    count++;
                }else {
                    pre = c;
                    count = 1;
                }

            }else {
                if (c.equals(pre)){
                    int i = idx + 1;
                    while (i < size && list.get(i).equals(pre)){
                        i++;
                    }
                    if (i >= size){
                        break;
                    }
                    res.append(list.get(i))
                            .append(c);
                    count = 1;
                    idx = i;
                }else {
                    count = 1;
                    pre = c;
                    res.append(c);
                }
            }
            idx++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Question6014().repeatLimitedString("cczazcc", 3));
//        System.out.println(new Question6014().repeatLimitedString("zzzcczazcc", 3));
//        System.out.println(new Question6014().repeatLimitedString("robnsdvpuxbapuqgopqvxdrchivlifeepy", 2));
        System.out.println(new Question6014().repeatLimitedString("bplpcfifosybmjxphbxdltxtfrjspgixoxzbpwrtkopepjxfooazjyosengdlvyfchqhqxznnhuuxhtbrojyhxwlsrklsryvmufoibgfyxgjw", 1));
    }
}
