import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 0, 0, 0, 1, -1};
	static final int[] dy = {0, 0, 1, -1, 0, 0};
	static final int[] dz = {1, -1, 0, 0, 0, 0};
	static int l, r, c;
	static char[][][] building;
	static boolean[][][] visited;
	static StringBuilder sb = new StringBuilder();

	static void bfs(int x, int y, int z) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, z, 0});
		visited[x][y][z] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (building[cur[0]][cur[1]][cur[2]] == 'E') {
				sb.append("Escaped in ").append(cur[3]).append(" minute(s).").append('\n');
				return;
			}
			for (int i = 0; i < 6; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				int nz = cur[2] + dz[i];
				if (nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c)
					continue;
				if (building[nx][ny][nz] != '#' && !visited[nx][ny][nz]) {
					q.offer(new int[] {nx, ny, nz, cur[3] + 1});
					visited[nx][ny][nz] = true;
				}
			}
		}
		sb.append("Trapped!").append('\n');
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if (l == 0 && r == 0 && c == 0) {
				System.out.println(sb.toString());
				return;
			}

			building = new char[l][r][c];
			visited = new boolean[l][r][c];
			int x = 0, y = 0, z = 0;
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String line = br.readLine();
					for (int k = 0; k < c; k++) {
						building[i][j][k] = line.charAt(k);
						if (building[i][j][k] == 'S') {
							building[i][j][k] = '.';
							x = i;
							y = j;
							z = k;
						}
					}
				}
				br.readLine();
			}
			bfs(x, y, z);
		}
	}
}
