import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int n = answers.length;
        int[] scores = new int[3];
        for (int i=0; i<n; i++) {
            if (answers[i] == one[i%5]) scores[0]++;
            if (answers[i] == two[i%8]) scores[1]++;
            if (answers[i] == three[i%10]) scores[2]++;
        }
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<3; i++)
            if (maxScore == scores[i])
                result.add(i+1);
        return result.stream().sorted().mapToInt(x->x).toArray();
    }
}