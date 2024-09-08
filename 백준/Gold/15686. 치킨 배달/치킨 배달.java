import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, answer;
	static int[][] board;
	static boolean[] open;
	static List<int[]> house, chicken;

	static void dfs(int at, int depth) {
		if (depth == m) {
			int sum = 0;
			for (int[] h : house) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (!open[j])
						continue;
					int distance = Math.abs(h[0] - chicken.get(j)[0]) + Math.abs(h[1] - chicken.get(j)[1]);
					min = Math.min(min, distance);
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = at; i < chicken.size(); i++) {
			open[i] = true;
			dfs(i + 1, depth + 1);
			open[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					house.add(new int[] {i, j});
				else if (board[i][j] == 2)
					chicken.add(new int[] {i, j});
			}
		}

		answer = Integer.MAX_VALUE;
		open = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.println(answer);
	}
}
