import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int n = board.length;
        for (int move : moves) {
            for (int r=0; r<n; r++) {
                int doll = board[r][move-1];
                if (doll != 0) {
                    board[r][move-1] = 0;
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(doll);
                    break;
                }
            }
        }
        return answer;
    }
}