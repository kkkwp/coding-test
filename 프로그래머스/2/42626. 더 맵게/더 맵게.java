import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int food : scoville)
            pq.add(food);
        
        int answer = 0;
        int min = pq.peek();
        while (min < K) {
            if (pq.size() < 2) 
                return -1;
            pq.add(pq.poll() + pq.poll() * 2);
            min = pq.peek();
            answer++;
        }
        return answer;
    }
}