import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	static int n, m;
	static int[][] board;
	static boolean[][][] visited;

	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1, 0}); // x, y, 거리, 벽을 부순 여부

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == n - 1 && cur[1] == m - 1)
				return cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (board[nx][ny] == 1) { // 벽인 경우
					if (cur[3] == 0 && !visited[0][nx][ny]) { // 벽을 부순 적이 없고 그 벽을 방문한 적이 없으면 부순다.
						q.offer(new int[] {nx, ny, cur[2] + 1, 1});
						visited[1][nx][ny] = true;
					}
				} else { // 벽이 아닌 경우
					if (!visited[cur[3]][nx][ny]) { // 벽을 부순 여부에 따라 체크한다.
						q.offer(new int[] {nx, ny, cur[2] + 1, cur[3]});
						visited[cur[3]][nx][ny] = true;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		visited = new boolean[2][n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
}
