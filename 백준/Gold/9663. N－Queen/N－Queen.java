import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int cnt;
	static int[] board;

	static boolean possible(int col) {
		for (int i = 0; i < col; i++) {
			// 행
			if (board[i] == board[col]) {
				return false;
			}
			// 대각선
			if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
				return false;
			}
		}
		return true;
	}

	static void dfs(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			board[depth] = i;
			if (possible(depth)) {
				dfs(depth + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n];
		dfs(0);
		System.out.println(cnt);
	}
}
