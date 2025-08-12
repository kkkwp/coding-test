import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        Queue<Process> q = new LinkedList<>();
        for (int i=0; i<n; i++)
            q.offer(new Process(priorities[i], i));
        
        int answer = 0;
        while (!q.isEmpty()) {
            Process cur = q.poll();
            boolean flag = true;
            for (Process p : q) {
                if (cur.priority < p.priority) {
                    flag = false; // 가장 높은 우선순위가 아님
                    break;
                }
            }
            
            if (flag) {
                answer++;
                if (cur.location == location) return answer;
            } else
                q.offer(cur);
        }
        return answer;
    }
}
                
class Process {
    int priority, location;
    
    Process(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}