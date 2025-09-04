import java.util.*;

class Solution {
    private int[] dx = {0, 0, 1, -1}; // 동서남북
    private int[] dy = {1, -1, 0, 0};
    private int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[]{0, 0, 1}); // r, c, 거리
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx == n-1 && ny == m-1) 
                    return cur[2]+1;
                
                if (!inRange(nx, ny)) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                q.offer(new int[]{nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
    
    private boolean inRange(int x, int y) {
        return 0<=x && x<n && 0<=y && y<m;
    }
}