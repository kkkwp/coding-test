import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	static int m, n;
	static int[][] board;
	static boolean[][] visited;

	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;
				if (board[nx][ny] == 0 && !visited[nx][ny]) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		board = new int[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			for (int j = startX; j < endX; j++) {
				for (int l = startY; l < endY; l++)
					board[l][j] = 1;
			}
		}

		List<Integer> areas = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0 && !visited[i][j]) {
					areas.add(bfs(i, j));
				}
			}
		}

		Collections.sort(areas);

		StringBuilder sb = new StringBuilder();
		sb.append(areas.size()).append('\n');
		for (int area : areas)
			sb.append(area).append(' ');
		System.out.println(sb);
	}
}
