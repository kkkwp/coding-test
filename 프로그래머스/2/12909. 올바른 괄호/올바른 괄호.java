import java.util.*;

class Solution {
    boolean solution(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '(')
                stack.push('(');
            else {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(')
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}