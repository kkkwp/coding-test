import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : number.toCharArray()) {
            // 스택의 맨 위 숫자가 현재 숫자보다 작으면 빼기
            while (!stack.isEmpty() && k>0 && stack.peek()<digit) {
                stack.pop();
                k--;
            }
            // 현재 숫자를 stack에 넣기
            stack.push(digit);
        }
        
        // k가 0보다 크면 스택의 맨 위(가장 작은 숫자)부터 k개 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택에 남아있는 숫자들 반환
        StringBuilder sb = new StringBuilder();
        for (char ch : stack)
            sb.append(ch);
        return sb.toString();
    }
}