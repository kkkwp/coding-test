import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static final int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};
	static int I;
	static int[][] board;
	static boolean[][] visited;

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || nx >= I || ny < 0 || ny >= I)
					continue;
				if (!visited[nx][ny]) {
					board[nx][ny] = board[cur[0]][cur[1]] + 1;
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (t-- > 0) {
			I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int curX = Integer.parseInt(st.nextToken());
			int curY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int goalX = Integer.parseInt(st.nextToken());
			int goalY = Integer.parseInt(st.nextToken());

			board = new int[I][I];
			visited = new boolean[I][I];
			bfs(curX, curY);
			System.out.println(board[goalX][goalY]);
		}
	}
}
