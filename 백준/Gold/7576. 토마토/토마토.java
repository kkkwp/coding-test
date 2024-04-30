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
	static Queue<int[]> q = new LinkedList<>();

	static boolean checkBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static int bfs() {
		int day = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			day = cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (board[nx][ny] == 0) {
					board[nx][ny] = 1;
					q.offer(new int[] {nx, ny, day + 1});
				}
			}
		}

		if (checkBoard()) {
			return day;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					q.offer(new int[] {i, j, 0});
				}
			}
		}
		System.out.println(bfs());
	}
}
