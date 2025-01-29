import java.util.Arrays;

class Solution {
    public long solution(long n) {
        char[] numbers = String.valueOf(n).toCharArray();
        Arrays.sort(numbers);
        
        StringBuilder sb = new StringBuilder(new String(numbers)).reverse();
        return Long.parseLong(sb.toString());
    }
}