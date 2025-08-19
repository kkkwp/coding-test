class Solution {
    static int n, answer = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        dfs(0, k, dungeons);
        return answer;
    }
    
    static void dfs(int depth, int cur, int[][] dungeons) {
        answer = Math.max(answer, depth);
        
        for (int i=0; i<n; i++) {
            int need = dungeons[i][0];
            int use = dungeons[i][1];
            if (!visited[i] && cur >= need) {
                visited[i] = true;
                dfs(depth+1, cur-use, dungeons);
                visited[i] = false;
            }
        }
    }
}