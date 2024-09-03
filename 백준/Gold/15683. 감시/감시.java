import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, answer;
	static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] mode = {
		{},
		{0},
		{0, 2},
		{0, 1},
		{0, 1, 2},
		{0, 1, 2, 3}
	};
	static List<int[]> cctv = new ArrayList<>();

	static void dfs(int depth, int[][] board) {
		if (depth == cctv.size()) {
			int area = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j] == 0)
						area++;
				}
			}
			answer = Math.min(answer, area);
			return;
		}

		int x = cctv.get(depth)[0];
		int y = cctv.get(depth)[1];
		int type = cctv.get(depth)[2];

		for (int i = 0; i < 4; i++) {
			int[][] newBoard = new int[n][m];
			for (int j = 0; j < n; j++)
				newBoard[j] = board[j].clone();

			for (int d : mode[type]) {
				int dir = (d + i) % 4;
				int nx = x;
				int ny = y;
				while (true) {
					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						break;
					if (board[nx][ny] == 6)
						break;
					newBoard[nx][ny] = -1;
					nx += move[dir][0];
					ny += move[dir][1];
				}
			}
			dfs(depth + 1, newBoard);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		answer = Integer.MAX_VALUE;
		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > 0 && board[i][j] < 6)
					cctv.add(new int[] {i, j, board[i][j]});
			}
		}
		dfs(0, board);
		System.out.println(answer);
	}
}
