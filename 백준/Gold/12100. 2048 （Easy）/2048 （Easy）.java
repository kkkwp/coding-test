import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, answer;
	static int[][] board;

	static void move(int dir) {
		switch (dir) {
			case 0: // 상
				for (int i = 0; i < n; i++) {
					int block = 0;
					int idx = 0;
					for (int j = 0; j < n; j++) {
						if (board[j][i] == 0)
							continue;
						if (board[j][i] == block) { // 같은 숫자끼리 충돌한 경우
							board[idx - 1][i] = block * 2;
							board[j][i] = 0;
							block = 0;
						} else { // 다른 숫자끼리 충돌한 경우
							block = board[j][i];
							board[j][i] = 0;
							board[idx++][i] = block;
						}
					}
				}
				break;
			case 1: // 하
				for (int i = 0; i < n; i++) {
					int block = 0;
					int idx = n - 1;
					for (int j = n - 1; j >= 0; j--) {
						if (board[j][i] == 0)
							continue;
						if (board[j][i] == block) {
							board[idx + 1][i] = block * 2;
							board[j][i] = 0;
							block = 0;
						} else {
							block = board[j][i];
							board[j][i] = 0;
							board[idx--][i] = block;
						}
					}
				}
				break;
			case 2: // 좌
				for (int i = 0; i < n; i++) {
					int block = 0;
					int idx = 0;
					for (int j = 0; j < n; j++) {
						if (board[i][j] == 0)
							continue;
						if (board[i][j] == block) {
							board[i][idx - 1] = block * 2;
							board[i][j] = 0;
							block = 0;
						} else {
							block = board[i][j];
							board[i][j] = 0;
							board[i][idx++] = block;
						}
					}
				}
				break;
			case 3: // 우
				for (int i = 0; i < n; i++) {
					int block = 0;
					int idx = n - 1;
					for (int j = n - 1; j >= 0; j--) {
						if (board[i][j] == 0)
							continue;
						if (board[i][j] == block) {
							board[i][idx + 1] = block * 2;
							board[i][j] = 0;
							block = 0;
						} else {
							block = board[i][j];
							board[i][j] = 0;
							board[i][idx--] = block;
						}
					}
				}
				break;
			default:
				break;
		}
	}

	static void dfs(int depth) {
		if (depth == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					answer = Math.max(answer, board[i][j]);
				}
			}
			return;
		}

		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++)
			copy[i] = board[i].clone();

		for (int i = 0; i < 4; i++) {
			move(i);
			dfs(depth + 1);
			for (int j = 0; j < n; j++)
				board[j] = copy[j].clone();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);
		System.out.println(answer);
	}
}
