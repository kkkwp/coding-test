import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int[] cnt = new int[2];

	static void partition(int r, int c, int n) {
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (board[i][j] != board[r][c]) {
					int half = n / 2;
					partition(r, c, half);
					partition(r, c + half, half);
					partition(r + half, c, half);
					partition(r + half, c + half, half);
					return;
				}
			}
		}
		cnt[board[r][c]]++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partition(0, 0, n);
		for (int x : cnt) {
			System.out.println(x);
		}
	}
}
