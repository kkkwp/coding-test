import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] visited = new int[100001];

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = cur + 1;
				} else if (i == 1) {
					next = cur - 1;
				} else {
					next = cur * 2;
				}
				if (next == k) {
					System.out.println(visited[cur]);
					return;
				}
				if (next >= 0 && next < 100001 && visited[next] == 0) {
					q.offer(next);
					visited[next] = visited[cur] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if (n == k) {
			System.out.println(0);
		} else {
			bfs(n);
		}
	}
}
