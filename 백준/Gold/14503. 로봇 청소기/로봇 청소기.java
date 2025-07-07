import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, answer = 0;
	static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r =  Integer.parseInt(st.nextToken());
		int c =  Integer.parseInt(st.nextToken());
		int d =  Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		dfs(r, c, d);
		System.out.println(answer);
	}

	static void dfs(int r, int c, int d) {
		if (!visited[r][c]) {
			visited[r][c] = true;
			answer++;
		}

		for (int i=0; i<4; i++) {
			d = (d + 3) % 4; // 반시계 방향으로 회전
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!visited[nr][nc] && map[nr][nc] == 0) {
				dfs(nr, nc, d);
				return;
			}
		}

		int back = (d + 2) % 4; // 후진
		int nr = r + dr[back];
		int nc = c + dc[back];
		if (map[nr][nc] == 0)
			dfs(nr, nc, d);
	}
}
