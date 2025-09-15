import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        // 친구들의 이름을 인덱스에 매핑
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++)
            map.put(friends[i], i);
        
        int[][] cnt = new int[n][n]; // 주고받은 선물
        int[] given = new int[n]; // 준 선물
        int[] received = new int[n]; // 받은 선물
        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            int from = map.get(tmp[0]);
            int to = map.get(tmp[1]);
            cnt[from][to]++;
            given[from]++;
            received[to]++;
        }
        
        // 선물지수 계산 (준 선물 - 받은 선물)
        int[] scores = new int[n];
        for (int i=0; i<n; i++)
            scores[i] = given[i] - received[i];
        
        // 다음 달 받게 될 선물
        int[] next = new int[n];
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int ij = cnt[i][j];
                int ji = cnt[j][i];
                if (ij > ji) next[i]++;
                else if (ij < ji) next[j]++;
                else {
                    if (scores[i] > scores[j]) next[i]++;
                    else if (scores[i] < scores[j]) next[j]++;
                }  
            }
        }
        
        int answer = 0;
        for (int i : next)
            answer = Math.max(answer, i);
        return answer;
    }
}