package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/11
 * @Time: 9:51
 * @Description: https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0,0,n,"");
        return list;
    }

    public void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            list.add(s);
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (right < left) {
            generate(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {

    }
}
