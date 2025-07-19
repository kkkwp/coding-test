import java.io.*;
import java.util.*;

public class Main {
	static int n, m, answer;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1}; // 동, 서, 남, 북
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new boolean[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				visited[i][j] = true;
				dfs(1, i, j, board[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(answer);
	}

	static void dfs(int depth, int x, int y, int sum) {
		if (depth == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!inRange(nx, ny) || visited[nx][ny]) continue;

			if (depth == 2) {
				visited[nx][ny] = true;
				dfs(depth+1, x, y, sum + board[nx][ny]);
				visited[nx][ny] = false;
			}
			visited[nx][ny] = true;
			dfs(depth+1, nx, ny, sum + board[nx][ny]);
			visited[nx][ny] = false;
		}
	}

	static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<m;
	}
}
