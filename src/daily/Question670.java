package daily;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/maximum-swap/
 * @since 2022/9/13 18:53
 */
public class Question670 {
    public int maximumSwap(int num) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        String s = Integer.toString(num);

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            queue.add(c - '0');
        }
        int swapX = 0, swapY = 0;
        for (int i = 0; i < charArray.length; i++) {
            int finger = charArray[i] - '0';
            Integer peek = queue.peek();
            if (peek != finger){
                for (int j = charArray.length - 1; j >= i; j--){
                    if (charArray[j] - '0' == peek){
                        swapX = i;
                        swapY = j;
                        break;
                    }
                }
                char temp = charArray[swapX];
                charArray[swapX] = charArray[swapY];
                charArray[swapY] = temp;
                String res = new String(charArray);
                return Integer.parseInt(res);
            }
            queue.poll();


        }
        return num;
    }


    public int maximumSwap1(int num) {
        String s = String.valueOf(num);
        char[] array = s.toCharArray();
        int idx1 = -1, idx2 = -1;
        int length = array.length;
        int maxId = length - 1;
        for (int i = length - 2; i >=0; i--){
            if (array[i] > array[maxId]){
                maxId = i;
            }else if (array[i] < array[maxId]){
                idx1 = i;
                idx2 = maxId;
            }
        }
        if (idx1 >= 0){
            char temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
            return Integer.parseInt(new String(array));
        }

        return num;
    }

    public static void main(String[] args) {
        Question670 question670 = new Question670();
        System.out.println(question670.maximumSwap(1993));
    }
}
