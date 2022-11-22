package weekly.contest270;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/contest/weekly-contest-270/problems/finding-3-digit-even-numbers/
 * @since 2021/12/5 10:30
 */
public class Question5942 {

    public int[] findEvenNumbers1(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        for (int i = 100; i < 1000; i += 2) {
            int[] used = new int[10];
            int temp = i;
            boolean flag = true;
            while (temp > 0) {
                int x = temp % 10;
                used[x]++;
                if (used[x] > count[x]) {
                    flag = false;
                    break;
                }
                temp /= 10;
            }
            if (flag) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public int[] findEvenNumbers(int[] digits) {
        //set:不能重复，用来保存结果达到去重
        Set<Integer> set = new HashSet<>();
        //byte数组统计使用情况
        byte[] used = new byte[digits.length];
        recur(digits, -1, set, 0, used);
        int[] res = new int[set.size()];
        int idx = 0;
        for (Integer integer : set) {
            res[idx++] = integer;
        }
        //结果要求递增
        Arrays.sort(res);
        return res;
    }

    public void recur(int[] digits, int index, Set<Integer> temp, int num, byte[] used) {
        //当前值大于100则返回
        if (num >= 100) {
            temp.add(num);
            return;
        }
        //数组越界则返回
        int length = digits.length;
        if (index >= length) {
            return;
        }
        for (int i = 0; i < length; i++) {
            //已被使用则跳过
            if (used[i] == 1) {
                continue;
            }
            //第一位不能为0
            if (num == 0 && digits[i] == 0) {
                continue;
            }
            //最后一位只能是偶数
            if (num >= 10 && (digits[i] & 1) != 0) {
                continue;
            }
            //将当前位加入
            num = num * 10 + digits[i];
            //当前数置为已使用
            used[i] = 1;
            //递归加入
            recur(digits, 0, temp, num, used);
            //复位
            used[i] = 0;
            num /= 10;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new Question5942().findEvenNumbers(new int[]{2, 1, 3, 0});
        System.out.println(Arrays.toString(numbers));
    }
}
