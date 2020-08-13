package interview;

import java.util.Arrays;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/13
 * @Time: 9:59
 * @Description: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {
    public static String replaceSpace(String s) {

        return s.replaceAll("\\s", "%20");
    }

    public static String replaceSpace1(String s) {
        char[] str = new char[s.length()*3];
        int size = 0;

        for(char c:s.toCharArray()){
            if (c==' '){
                str[size++] = '%';
                str[size++] = '2';
                str[size++] = '0';
            }else {
                str[size++] = c;
            }
        }
        return new String(str, 0,size);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace1("We are happy."));
    }
}
