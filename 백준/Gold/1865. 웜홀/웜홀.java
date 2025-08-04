import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 100_000_000;
	static int n, m, w;
	static List<Edge> edges; // 간선 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (tc-->0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 지점의 수
			m = Integer.parseInt(st.nextToken()); // 도로의 수
			w = Integer.parseInt(st.nextToken()); // 웜홀의 수
			edges = new ArrayList<>();
			// 도로: 양방향
			while (m-->0) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges.add(new Edge(s, e, t));
				edges.add(new Edge(e, s, t));
			}
			// 웜홀: 단방향
			while (w-->0) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges.add(new Edge(s, e, -t));
			}
			System.out.println(bellmanFord() ? "YES" : "NO");
		}
	}

	static boolean bellmanFord() {
		int[] dist = new int[n+1];
		Arrays.fill(dist, 0);

		// n번 반복
		for (int i=1; i<=n; i++) {
			for (Edge e : edges) {
				if (dist[e.to] > dist[e.from] + e.weight) {
					dist[e.to] = dist[e.from] + e.weight;
					// n번째에도 갱신된다면 음수 사이클 존재
					if (i == n) return true;
				}
			}
		}
		return false;
	}
}

class Edge {
	int from, to, weight;

	Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}
