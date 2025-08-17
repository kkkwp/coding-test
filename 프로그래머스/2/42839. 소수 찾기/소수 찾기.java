import java.util.*;

class Solution {
    static int n;
    static char[] digits;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        n = numbers.length();
        digits = numbers.toCharArray();
        visited = new boolean[n];
        
        permutate("");
        
        int answer = 0;
        for (int num : set)
            if (isPrime(num))
                answer++;
        return answer;
    }
    
    private void permutate(String num) {
        if (!num.isEmpty())
            set.add(Integer.parseInt(num));
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutate(num + digits[i]);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) 
            return false;
        for (int i=2; i<=Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}