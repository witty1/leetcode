package topInterview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/15
 * @Time: 15:45
 * @Description: https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Interview14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String ans = strs[0];
        int j;
        for (int i = 0; i < strs.length; i++) {
            for (j = 0; j < strs[i].length() && j<ans.length(); j++) {
                if (strs[i].charAt(j)!=ans.charAt(j)){
                    break;
                }

            }
            ans = ans.substring(0,j);
            if (ans.length()==0){
                return "";
            }
        }
        return ans;
    }
}
