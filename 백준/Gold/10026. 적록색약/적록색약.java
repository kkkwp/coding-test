import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	static int n;
	static char[][] board;
	static boolean[][] visited;

	static void bfs(int x, int y) {
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
				if (board[nx][ny] == board[cur[0]][cur[1]] && !visited[nx][ny]) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new char[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
				if (board[i][j] == 'R')
					board[i][j] = 'G';
			}
		}
		sb.append(cnt).append(' ');

		cnt = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}
