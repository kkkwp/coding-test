import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 지도의 크기
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i=0; i<n; i++) {
			String line = br.readLine();
			for (int j=0; j<n; j++)
				map[i][j] = line.charAt(j) - '0';
		}

		List<Integer> result = new ArrayList<>(); // 단지별 집의 수
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				// 맨 처음 만나는 미방문 집이 시작점! 어차피 단지의 나머지 집은 다 방문처리됨
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					bfs(i, j);
					result.add(cnt);
				}
			}
		}

		System.out.println(result.size());
		Collections.sort(result);
		for (int r : result)
			System.out.println(r);
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{r, c});
		visited[r][c] = true;
		cnt++;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d=0; d<4; d++) {
				int nx = cur[0] + dr[d];
				int ny = cur[1] + dc[d];
				if (!inRange(nx, ny)) continue;
				if (map[nx][ny] == 0 || visited[nx][ny]) continue;
				q.add(new int[]{nx, ny});
				visited[nx][ny] = true;
				cnt++;
			}
		}
	}

	static boolean inRange(int r, int c) {
		return 0<=r && r<n && 0<=c && c<n;
	}
}