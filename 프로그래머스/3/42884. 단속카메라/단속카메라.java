import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        int pos = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > pos) {
                answer++;
                pos = route[1];
            }
        }
        return answer;
    }
}