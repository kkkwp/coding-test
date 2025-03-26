import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for (int cost:d) {
            if (sum+cost <= budget) {
                sum += cost;
                answer++;
            }
        }
        return answer;
    }
}