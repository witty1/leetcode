/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package interview;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/10/23 17:06
 * @description: https://leetcode-cn.com/problems/is-unique-lcci/
 */
public class IsUniqueIcci {

    /**
     * 开辟一个52位长度的数组，用来代表a-Z的字母是否被使用过
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        char[] charArray = astr.toCharArray();
        int[] count = new int[52];
        for (char c : charArray) {
            int i = (int) c % 52;
            if (count[i] == 1){
                return false;
            }
            count[i] = 1;
        }
        return true;
    }


    /**
     * int占32位，字符在a-z之间，每一个对应一位
     * @param astr
     * @return
     */
    public boolean isUnique1(String astr) {
        char[] array = astr.toCharArray();
        int state = 0;
        for (char c : array) {
            //move的值在0-25之间
            int move = c - 'a';
            //1 << move的意思是找到字符对应的位置，如果当前位已经被使用则 state & 1 << move的结果肯定为1，
            if ((state & 1 << move) != 0) {
                return false;
            }
            // | 更新被使用的字符
            state |= 1 << move;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsUniqueIcci().isUnique1("leetcode"));
    }
}
