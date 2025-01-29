import java.util.*;

public class Solution {
    public int solution(int n) {
        String numbers = Integer.toString(n);
        int sum = 0;
        for (int i=0; i<numbers.length(); i++)
            sum += numbers.charAt(i) - '0';
        return sum;
    }
}