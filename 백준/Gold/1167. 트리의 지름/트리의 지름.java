import java.io.*;
import java.util.*;

public class Main {
	static int v;
	static int maxNode, maxDist;
	static List<Edge>[] tree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine()); // 트리의 정점의 개수

		// 트리 초기화
		tree = new ArrayList[v+1];
		for (int i=1; i<=v; i++)
			tree[i] = new ArrayList<>();

		StringTokenizer st;
		for (int i=1; i<=v; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) break;
				int dist = Integer.parseInt(st.nextToken());
				tree[from].add(new Edge(to, dist));
			}
		}

		// 임의의 노드 1에서 가장 먼 노드를 찾고
		visited = new boolean[v+1];
		maxNode = 1; maxDist = 0;
		dfs(1, 0);

		// 그 노드에서 다시 가장 먼 노드까지의 거리를 계산
		visited = new boolean[v+1];
		maxDist = 0;
		dfs(maxNode, 0);
		System.out.println(maxDist);;
	}

	static void dfs(int node, int dist) {
		visited[node] = true;
		if (dist > maxDist) {
			maxDist = dist;
			maxNode = node;
		}
		for (Edge edge : tree[node]) {
			if (!visited[edge.to])
				dfs(edge.to, dist + edge.weight);
		}
	}
}

class Edge {
	int to, weight;

	Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
