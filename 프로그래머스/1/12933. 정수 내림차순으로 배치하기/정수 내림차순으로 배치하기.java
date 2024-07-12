import java.util.Arrays;

class Solution {
    public long solution(long n) {
        char[] numbers = String.valueOf(n).toCharArray();
        Arrays.sort(numbers);
        
        StringBuilder sb = new StringBuilder();
        for (char number : numbers) {
            sb.append(number);
        }
        return Long.parseLong(sb.reverse().toString());
    }
}