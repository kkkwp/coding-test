import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] board, dist;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열

		board = new int[n][m];
		dist = new int[n][m];
		for (int i=0; i<n; i++) {
			String line = br.readLine();
			for (int j=0; j<m; j++)
				board[i][j] = line.charAt(j) - '0';
		}
		bfs(0, 0);
		System.out.println(dist[n-1][m-1]);
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{r, c});
		dist[r][c] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d=0; d<4; d++) {
				int nx = cur[0] + dr[d];
				int ny = cur[1] + dc[d];

				if (!inRange(nx, ny)) continue;
				if (board[nx][ny] == 0) continue;
				if (dist[nx][ny] != 0) continue;

				q.add(new int[]{nx, ny});
				dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
			}
		}
	}

	static boolean inRange(int r, int c) {
		return 0<=r && r<n && 0<=c && c<m;
	}
}