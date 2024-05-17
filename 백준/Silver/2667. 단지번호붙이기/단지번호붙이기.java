import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	static int n, cnt;
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Integer> houses;

	static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if (board[nx][ny] == 1 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = input.charAt(j) - '0';
			}
		}

		houses = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					houses.add(cnt);
				}
			}
		}

		Collections.sort(houses);

		StringBuilder sb = new StringBuilder();
		sb.append(houses.size()).append("\n");
		for (int house : houses) {
			sb.append(house).append("\n");
		}
		System.out.println(sb);
	}
}
