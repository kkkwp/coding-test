public class Solution {
    public int solution(int n) {
        char[] numbers = Integer.toString(n).toCharArray();
        int answer = 0;
        for (char c : numbers) {
            answer += Integer.parseInt(String.valueOf(c));
        }
        return answer;
    }
}