import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> adj;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
		int m = Integer.parseInt(st.nextToken()); // 간선의 개수 m
		int v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호 v

		// 인접리스트 초기화 (처음부터 n번까지)
		adj = new ArrayList<>();
		for (int i=0; i<=n; i++)
			adj.add(new ArrayList<>());
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj.get(from).add(to);
			adj.get(to).add(from);
		}

		// 번호 작은 순으로 정렬
		for (int i=1; i<=n; i++)
			Collections.sort(adj.get(i));

		visited = new boolean[n+1];
		dfs(v);
		sb.append('\n');
		visited = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}

	static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(' ');
		for (int next : adj.get(v))
			if (!visited[next])
				dfs(next);
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(' ');
			for (int next : adj.get(cur)) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
