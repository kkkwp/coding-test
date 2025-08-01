import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int maxNode, maxDist;
	static List<Edge>[] tree; // 인접 리스트
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// 트리 초기화
		tree = new ArrayList[n+1];
		for (int i=1; i<=n; i++)
			tree[i] = new ArrayList<>();

		StringTokenizer st;
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[parent].add(new Edge(child, weight));
			tree[child].add(new Edge(parent, weight));
		}

		// 트리의 지름 찾기
		// 1. 루트에서 가장 먼 노드 A를 찾고
		visited = new boolean[n+1];
		maxNode = 1; maxDist = 0;
		dfs(1, 0);

		// 2. 노드 A에서 다시 가장 먼 노드 B 까지의 거리를 계산
		visited = new boolean[n+1];
		maxDist = 0;
		dfs(maxNode, 0);
		System.out.println(maxDist);
	}

	static void dfs(int node, int dist) {
		visited[node] = true;
		if (dist > maxDist) {
			maxDist = dist;
			maxNode = node;
		}
		for (Edge edge : tree[node])
			if (!visited[edge.to])
				dfs(edge.to, dist + edge.weight);
	}
}

class Edge {
	int to, weight;

	Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
