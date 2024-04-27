import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] graph;
	static boolean[] visited;

	static void dfs(int x) {
		visited[x] = true;
		for (int i = 1; i <= n; i++) {
			if (graph[x][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = 1;
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
}
