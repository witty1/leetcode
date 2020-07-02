package daily;

import java.util.Stack;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/2
 * @Time: 8:04
 * @Description: https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || s.charAt(i) != stack.pop()) {
                return false;
            }

        }

        return stack.isEmpty();
    }
}
