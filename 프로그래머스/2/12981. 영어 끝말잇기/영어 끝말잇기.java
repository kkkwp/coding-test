import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);
        
        int size = words.length;
        for (int i=1; i<size; i++) {
            String prev = words[i-1];
            String cur = words[i];
            
            // 탈락 조건: 중복 단어를 사용한 경우 / 앞 단어 끝과 현재 단어의 시작이 다른 경우
            if (used.contains(cur) || prev.charAt(prev.length()-1) != cur.charAt(0)) {
                int player = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[]{player, turn};
            }
            used.add(cur);
        }
        return new int[]{0, 0};
    }
}