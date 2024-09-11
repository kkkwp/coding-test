import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {1, -1, 0, 0};
	static int n, m, x, y;
	static int[] dice = new int[6];
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	static void roll(int dir, int x, int y) {
		int tmp = dice[5];
		switch (dir) {
			case 0: // 동
				dice[5] = dice[2];
				dice[2] = dice[0];
				dice[0] = dice[3];
				dice[3] = tmp;
				break;
			case 1: // 서
				dice[5] = dice[3];
				dice[3] = dice[0];
				dice[0] = dice[2];
				dice[2] = tmp;
				break;
			case 2: // 북
				dice[5] = dice[1];
				dice[1] = dice[0];
				dice[0] = dice[4];
				dice[4] = tmp;
				break;
			case 3: // 남
				dice[5] = dice[4];
				dice[4] = dice[0];
				dice[0] = dice[1];
				dice[1] = tmp;
				break;
			default:
				break;
		}

		if (map[x][y] == 0)
			map[x][y] = dice[5];
		else {
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
		sb.append(dice[0]).append('\n');
	}

	static void move(int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			return;
		roll(dir, nx, ny);
		x = nx;
		y = ny;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int dir = Integer.parseInt(st.nextToken());
			move(dir - 1);
		}
		System.out.println(sb);
	}
}
