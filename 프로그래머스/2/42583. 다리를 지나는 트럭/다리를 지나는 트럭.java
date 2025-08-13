import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int on = 0; // 현재 다리 위 트럭 무게의 합
        
        // 대기
        Queue<Integer> q = new LinkedList<>();
        for (int t : truck_weights)
            q.add(t);
        
        // 다리
        Queue<Integer> bridge = new LinkedList<>();
        for (int i=0; i<bridge_length; i++)
            bridge.add(0);
        
        while (!q.isEmpty()) {
            time++;
            on -= bridge.poll();
            // 현재 다리에 트럭이 올라갈 수 없으면 0 추가 → 시간만 흐름
            if (on + q.peek() > weight)
                bridge.add(0);
            else {
                int truck = q.poll();
                bridge.add(truck);
                on += truck;
            }
        }
        // 마지막 트럭이 다리에 진입한 후, 다리 길이만큼의 시간이 더 지나야 완전히 건널 수 있음
        return time + bridge_length;
    }
}