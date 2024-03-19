import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] board;

	static int getCost(int r, int c) {
		boolean start = board[r][c];
		int cost = 0;
		for (int i = r; i < r + 8; i++) {
			for (int j = c; j < c + 8; j++) {
				if (board[i][j] != start) {
					cost++;
				}
				start = !start;
			}
			start = !start;
		}
		return Math.min(cost, 64 - cost);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		board = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j) == 'W';
			}
		}

		int answer = 64;
		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				answer = Math.min(answer, getCost(i, j));
			}
		}
		System.out.println(answer);
	}
}
