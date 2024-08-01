import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String result = new String(arr);
        return new StringBuilder(result).reverse().toString();
    }
}