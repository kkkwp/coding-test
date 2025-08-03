import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 100_000_000;
	static int n, m, x;
	static List<Edge>[] go, come;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 학생 수
		m = Integer.parseInt(st.nextToken()); // 도로 수
		x = Integer.parseInt(st.nextToken()); // 시작점
		go = new ArrayList[n+1];
		come = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			go[i] = new ArrayList<>();
			come[i] = new ArrayList<>();
		}
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			go[from].add(new Edge(to, time));
			come[to].add(new Edge(from, time));
		}

		int[] distFromX = dijkstra(go);
		int[] distToX = dijkstra(come);
		int answer = 0;
		for (int i=1; i<=n; i++)
			answer = Math.max(answer, distFromX[i] + distToX[i]);
		System.out.println(answer);
	}

	static int[] dijkstra(List<Edge>[] graph) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.time));
		pq.offer(new Edge(x, 0));

		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[x] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.time > dist[cur.to]) continue;
			for (Edge next : graph[cur.to]) {
				if (dist[next.to] > dist[cur.to] + next.time) {
					dist[next.to] = dist[cur.to] + next.time;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
}

class Edge {
	int to, time;

	Edge(int to, int time) {
		this.to = to;
		this.time = time;
	}
}
