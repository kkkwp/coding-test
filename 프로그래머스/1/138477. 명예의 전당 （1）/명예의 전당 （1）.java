import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int days = score.length;
        int[] answer = new int[days];
        for (int i=0; i<days; i++) {
            pq.offer(score[i]);
            if (pq.size() > k)
                pq.poll();
            answer[i] = pq.peek();
        }
        return answer;
    }
}