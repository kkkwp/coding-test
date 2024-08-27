import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (board[i][j] != board[x][y])
					return false;
			}
		}
		return true;
	}

	static void recur(int x, int y, int size) {
		if (check(x, y, size)) {
			sb.append(board[x][y]);
			return;
		}
		int newSize = size / 2;
		sb.append('(');
		recur(x, y, newSize);
		recur(x, y + newSize, newSize);
		recur(x + newSize, y, newSize);
		recur(x + newSize, y + newSize, newSize);
		sb.append(')');
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}

		recur(0, 0, n);
		System.out.println(sb);
	}
}
