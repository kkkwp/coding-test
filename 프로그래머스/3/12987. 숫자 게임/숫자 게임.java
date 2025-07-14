import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0, b = 0, score = 0;
        while (a<A.length && b<B.length) {
            if (A[a] < B[b]) {
                score++;
                a++;
            }
            b++;
        }
        return score;
    }
}