import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> adj;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int m = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수

		adj = new ArrayList<>();
		for (int i=0; i<=n; i++)
			adj.add(new ArrayList<>());

		StringTokenizer st;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj.get(from).add(to);
			adj.get(to).add(from);
		}

		visited = new boolean[n+1];
		dfs(1);
		System.out.println(cnt);
	}

	static void dfs(int start) {
		visited[start] = true;
		for (int next : adj.get(start)) {
			if (!visited[next]) {
				cnt++;
				dfs(next);
			}
		}
	}
}