import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works)
            pq.add(work);
        
        while (n>0) {
            int max = pq.poll();
            if (max == 0) break;
            pq.add(max - 1);
            n--;
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long)work * work;
        }
        return answer;
    }
}