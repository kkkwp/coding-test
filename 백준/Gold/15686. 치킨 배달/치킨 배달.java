import java.io.*;
import java.util.*;

public class Main {
	static int n, m, answer = Integer.MAX_VALUE;
	static int[][] board;
	static boolean[] selected;
	static List<int[]> homes = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) homes.add(new int[]{i, j});
				else if (board[i][j] == 2) chickens.add(new int[]{i, j});
			}
		}
		selected = new boolean[chickens.size()];
		dfs(0, 0);
		System.out.println(answer);
	}

	static void dfs(int depth, int at) {
		if (depth == m) {
			answer = Math.min(answer, getDistance());
			return;
		}

		for (int i=at; i<chickens.size(); i++) {
			selected[i] = true;
			dfs(depth+1, i+1);
			selected[i] = false;
		}
	}

	static int getDistance() {
		int sum = 0;
		for (int[] home : homes) {
			int min = Integer.MAX_VALUE;
			for (int i=0; i<chickens.size(); i++) {
				if (!selected[i]) continue;
				int[] chicken = chickens.get(i);
				int dist = Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
				min = Math.min(min, dist);
			}
			sum += min;
		}
		return sum;
	}
}
