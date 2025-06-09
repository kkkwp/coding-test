import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : "RTCFJMAN".toCharArray())
            map.put(ch, 0);
        
        int n = survey.length;
        for (int i=0; i<n; i++) {
            int choice = choices[i];
            char key;
            if (choice < 4) {
                key = survey[i].charAt(0);
                map.put(key, map.get(key) + (4 - choice));
            } else {
                key = survey[i].charAt(1);
                map.put(key, map.get(key) + (choice - 4));
            }  
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') >= map.get('N') ? 'A' : 'N');
        return sb.toString();
    }
}