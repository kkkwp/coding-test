class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int cur, int n, int[][] computers) {
        visited[cur] = true;
        for (int i=0; i<n; i++)
            if (!visited[i] && computers[cur][i] == 1)
                dfs(i, n, computers);
    }
}