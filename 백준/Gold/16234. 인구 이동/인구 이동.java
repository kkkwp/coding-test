import java.io.*;
import java.util.*;

public class Main {
	static int n, l, r;
	static int[][] a;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		while (true) {
			visited = new boolean[n][n];
			boolean flag = false;
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (visited[i][j]) continue;
					if (bfs(i, j)) flag = true;
				}
			}
			if (!flag) break;
			answer++;
		}
		System.out.println(answer);
	}

	static boolean bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;

		List<int[]> union = new ArrayList<>();
		union.add(new int[]{x, y});

		int sum = a[x][y];
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d=0; d<4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (!inRange(nx, ny) || visited[nx][ny]) continue;
				int diff = Math.abs(a[cur[0]][cur[1]] - a[nx][ny]);
				if (l <= diff && diff <= r) {
					visited[nx][ny] = true;
					q.add(new int[]{nx, ny});
					union.add(new int[]{nx, ny});
					sum += a[nx][ny];
				}
			}
		}
		if (union.size() == 1) return false;

		int avg = sum / union.size();
		for (int[] u : union)
			a[u[0]][u[1]] = avg;
		return true;
	}

	static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
}
