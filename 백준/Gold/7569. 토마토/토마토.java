import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 0, 0, 0, 1, -1};
	static final int[] dy = {0, 0, -1, 1, 0, 0};
	static final int[] dz = {1, -1, 0, 0, 0, 0};
	static int m, n, h;
	static int[][][] board;
	static Queue<Point> q = new LinkedList<>();

	static int bfs() {
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 6; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nz = cur.z + dz[i];
				if (nx < 0 || nx >= h || ny < 0 || ny >= n || nz < 0 || nz >= m)
					continue;
				if (board[nx][ny][nz] == 0) {
					q.offer(new Point(nx, ny, nz));
					board[nx][ny][nz] = board[cur.x][cur.y][cur.z] + 1;
				}
			}
		}

		int days = Integer.MIN_VALUE;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (board[i][j][k] == 0)
						return -1;
					days = Math.max(days, board[i][j][k]);
				}
			}
		}
		return days == 1 ? 0 : days - 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		board = new int[h][n][m];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == 1) {
						q.offer(new Point(i, j, k));
					}
				}
			}
		}
		System.out.println(bfs());
	}

	static class Point {
		int x, y, z;

		Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
