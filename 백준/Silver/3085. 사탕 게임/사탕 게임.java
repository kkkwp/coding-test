import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] board;
	static int max = 1;

	static void swap(int x1, int y1, int x2, int y2) {
		char tmp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = tmp;
	}

	static void search(int n) {
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (board[i][j] == board[i][j + 1]) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					cnt = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (board[j][i] == board[j + 1][i]) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					cnt = 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				swap(i, j, i, j + 1);
				search(n);
				swap(i, j + 1, i, j);
			}
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				swap(i, j, i + 1, j);
				search(n);
				swap(i + 1, j, i, j);
			}
		}
		System.out.println(max);
	}
}
