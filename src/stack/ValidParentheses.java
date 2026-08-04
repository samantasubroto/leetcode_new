package stack;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char peek = stack.peek();
                if ((c == ')' && peek != '(') || (c == '}' && peek != '{') || (c == '[' && peek != ']')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[()()]{}";
        System.out.println((isValid(s) ? "true" : "false"));
    }
}
