import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] graph;
	static boolean[] visited;
	static int cnt;

	static int dfs(int cur) {
		visited[cur] = true;
		for (int i = 1; i <= n; i++) {
			if (graph[cur][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x] = 1;
		}
		System.out.println(dfs(1));
	}
}
