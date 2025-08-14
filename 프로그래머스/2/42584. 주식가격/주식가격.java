import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        // 스택이 비어있지 않고, 현재 가격이 stack의 top에 있는 값보다 낮다면 → 가격이 떨어진 것이므로 기간 계산
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx; // 현재 시간 - 이전 시간
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx; // 마지막 시간 - 이전 시간
        }
        return answer;
    }
}