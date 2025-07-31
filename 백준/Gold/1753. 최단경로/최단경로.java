import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int V, E, K;
	static List<Edge>[] graph; // 인접 리스트
	static int[] dist; // 시작 정점에서 i번 정점까지의 최단 거리(다익스트라)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

		// dist 배열 초기화
		dist = new int[V+1];
		Arrays.fill(dist, INF);

		// 그래프 초기화
		graph = new ArrayList[V+1];
		for (int i=1; i<=V; i++)
			graph[i] = new ArrayList<>();

		while (E-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // u에서
			int v = Integer.parseInt(st.nextToken()); // v로 가는
			int w = Integer.parseInt(st.nextToken()); // 가중치 w인 간선
			graph[u].add(new Edge(v, w));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=V; i++)
			sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			// 이미 알고 있는 최단거리가 가중치보다 크면 패스
			if (dist[cur.to] < cur.weight) continue;

			// 연결된 간선을 탐색
			for (Edge next : graph[cur.to]) {
				// 예상되는 값은 현재 알고 있는 최단거리 + 가중치
				int expect = dist[cur.to] + next.weight;
				// 예상되는 값이 갈 곳의 최단거리보다 작으면 최단 거리를 갱신 + pq에 누적 가중치 넣기
				// pq는 i점까지 가는 총 비용을 기분으로 정렬해야 한다.
				if (expect < dist[next.to]) {
					dist[next.to] = expect;
					pq.offer(new Edge(next.to, expect));
				}
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int to, weight;

	Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge other) {
		return this.weight - other.weight;
	}
}
