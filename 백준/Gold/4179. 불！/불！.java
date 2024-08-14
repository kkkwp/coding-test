import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	static int r, c, answer;
	static char[][] board;
	static Queue<int[]> jihun = new LinkedList<>();
	static Queue<int[]> fire = new LinkedList<>();

	static boolean bfs() {
		while (!jihun.isEmpty()) {
			// 불
			int fizeSize = fire.size();
			for (int i = 0; i < fizeSize; i++) {
				int[] cur = fire.poll();
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (board[nx][ny] != '#' && board[nx][ny] != 'F') {
						fire.offer(new int[] {nx, ny, cur[2] + 1});
						board[nx][ny] = 'F';
					}
				}
			}
			// 지훈
			int jihunSize = jihun.size();
			for (int i = 0; i < jihunSize; i++) {
				int[] cur = jihun.poll();
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
						answer = cur[2] + 1;
						return true;
					}
					if (board[nx][ny] != '#' && board[nx][ny] != 'F' && board[nx][ny] != 'J') {
						jihun.offer(new int[] {nx, ny, cur[2] + 1});
						board[nx][ny] = 'J';
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (board[i][j] == 'J') {
					jihun.offer(new int[] {i, j, 0});
				} else if (board[i][j] == 'F') {
					fire.offer(new int[] {i, j, 0});
				}
			}
		}
		System.out.println(bfs() ? answer : "IMPOSSIBLE");
	}
}
