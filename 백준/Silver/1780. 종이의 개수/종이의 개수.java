import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int minus, zero, one;

	static boolean check(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (board[r][c] != board[i][j])
					return false;
			}
		}
		return true;
	}

	static void recur(int r, int c, int size) {
		if (check(r, c, size)) {
			int cur = board[r][c];
			if (cur == -1)
				minus++;
			else if (cur == 0)
				zero++;
			else
				one++;
			return;
		}
		int newSize = size / 3;
		recur(r, c, newSize);
		recur(r, c + newSize, newSize);
		recur(r, c + 2 * newSize, newSize);
		recur(r + newSize, c, newSize);
		recur(r + newSize, c + newSize, newSize);
		recur(r + newSize, c + 2 * newSize, newSize);
		recur(r + 2 * newSize, c, newSize);
		recur(r + 2 * newSize, c + newSize, newSize);
		recur(r + 2 * newSize, c + 2 * newSize, newSize);
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

		recur(0, 0, n);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
}
