import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        int answer = Integer.MAX_VALUE;
        
        // 모든 전선을 하나씩 끊어보기(완전 탐색)
        for (int w=0; w<n-1; w++) {
            // 그래프 그리기
            for (int i=1; i<=n; i++)
                graph[i] = new ArrayList<>();
            for (int i=0; i<n-1; i++) {
                if (i == w) continue;
                graph[wires[i][0]].add(wires[i][1]);
                graph[wires[i][1]].add(wires[i][0]);
            }
            // 탐색
            visited = new boolean[n+1];
            int cnt = dfs(wires[w][0]);
            answer = Math.min(answer, Math.abs(cnt - (n-cnt)));
        }
        return answer;
    }
    
    static int dfs(int cur) {
        int cnt = 1;
        visited[cur] = true;
        for (int next : graph[cur])
            if (!visited[next])
                cnt += dfs(next);
        return cnt;
    }
}