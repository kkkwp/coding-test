import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<name.length; i++)
            map.put(name[i], yearning[i]);
        
        int n = photo.length;
        int[] answer = new int[n];
        for (int i=0; i<n; i++)
            for (String p : photo[i])
                answer[i] += map.getOrDefault(p, 0);
        return answer;
    }
}