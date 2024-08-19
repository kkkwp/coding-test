import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int f, s, g, u, d;
	static int[] visited;

	static String bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == g)
				return String.valueOf(visited[cur] - 1);
			if (cur + u <= f && visited[cur + u] == 0) {
				visited[cur + u] = visited[cur] + 1;
				q.offer(cur + u);
			}
			if (cur - d > 0 && visited[cur - d] == 0) {
				visited[cur - d] = visited[cur] + 1;
				q.offer(cur - d);
			}
		}
		return "use the stairs";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		visited = new int[f + 1];
		System.out.println(bfs(s));
	}
}
