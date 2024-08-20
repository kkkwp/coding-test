import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	static int n;
	static int[][] board;
	static boolean[][] visited;

	static void bfs(int x, int y, int h) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (board[nx][ny] > h && !visited[nx][ny]) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new int[n][n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > max)
					max = board[i][j];
			}
		}

		int answer = 0;
		for (int h = 0; h < max; h++) {
			visited = new boolean[n][n];
			int area = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] > h && !visited[i][j]) {
						bfs(i, j, h);
						area++;
					}
				}
			}
			answer = Math.max(answer, area);
		}
		System.out.println(answer);
	}
}
