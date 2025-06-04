import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int n = targets.length;
        int[] answer = new int[n];
        
        Map<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                int press = map.getOrDefault(c, i+1);
                map.put(c, Math.min(press, i+1));
            }
        }
        
        for (int i=0; i<targets.length; i++) {
            for (int j=0; j<targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (!map.containsKey(c)) {
                    answer[i] = -1;
                    break;
                } else
                    answer[i] += map.get(c);
            }
        }
        return answer;
    }
}