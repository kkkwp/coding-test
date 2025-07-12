import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[][] a;
	static boolean[][] visited;
	static List<int[]> clouds = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		// 구름의 초기 위치
		clouds.add(new int[]{n-1, 0});
		clouds.add(new int[]{n-1, 1});
		clouds.add(new int[]{n-2, 0});
		clouds.add(new int[]{n-2, 1});

		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			moveCloudsAndRain(d, s);
			doMagic();
			makeNewClouds();
		}

		int sum = 0;
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				sum += a[i][j];
		System.out.println(sum);
	}

	static void moveCloudsAndRain(int d, int s) {
		visited = new boolean[n][n];
		for (int[] c : clouds) {
			c[0] = (c[0] + n + dr[d] * (s % n)) % n;
			c[1] = (c[1] + n + dc[d] * (s % n)) % n;
			visited[c[0]][c[1]] = true;
			
			a[c[0]][c[1]]++; // 각 구름에서 비가 내림
		}
	}

	static void doMagic() {
		for (int[] c : clouds) {
			int cnt = 0; // 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수
			for (int d=1; d<8; d+=2) { // 대각선 방향만
				int nr = c[0] + dr[d];
				int nc = c[1] + dc[d];
				if (inRange(nr, nc) && a[nr][nc] >= 1)
					cnt++;
			}
			a[c[0]][c[1]] += cnt;
		}
	}

	static boolean inRange(int r, int c) {
		return 0<=r && r<n && 0<=c && c<n;
	}

	static void makeNewClouds() {
		// 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
		// 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
		List<int[]> newClouds = new ArrayList<>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (!visited[i][j] && a[i][j] >= 2) {
					newClouds.add(new int[]{i, j});
					a[i][j] -= 2;
				}
			}
		}
		clouds = newClouds; // 기존 구름을 초기화하고, 새로운 구름 할당
	}
}
