import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	static int w, h, answer;
	static char[][] board;
	static Queue<int[]> sanggeun, fire;

	static boolean bfs() {
		while (!sanggeun.isEmpty()) {
			// 불
			int fireSize = fire.size();
			for (int i = 0; i < fireSize; i++) {
				int[] cur = fire.poll();
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w)
						continue;
					if (board[nx][ny] == '.' || board[nx][ny] == '@') {
						fire.offer(new int[] {nx, ny, cur[2] + 1});
						board[nx][ny] = '*';
					}
				}
			}
			// 상근
			int sanggeunSize = sanggeun.size();
			for (int i = 0; i < sanggeunSize; i++) {
				int[] cur = sanggeun.poll();
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
						answer = cur[2] + 1;
						return true;
					}
					if (board[nx][ny] == '.') {
						sanggeun.offer(new int[] {nx, ny, cur[2] + 1});
						board[nx][ny] = '@';
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			board = new char[h][w];
			sanggeun = new LinkedList<>();
			fire = new LinkedList<>();
			for (int i = 0; i < h; i++) {
				board[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if (board[i][j] == '@')
						sanggeun.offer(new int[] {i, j, 0});
					else if (board[i][j] == '*')
						fire.offer(new int[] {i, j, 0});
				}
			}
			answer = 0;
			System.out.println(bfs() ? answer : "IMPOSSIBLE");
		}
	}
}
