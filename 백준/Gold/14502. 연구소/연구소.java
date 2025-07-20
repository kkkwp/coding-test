import java.io.*;
import java.util.*;

public class Main {
	static int n, m, answer = 0;
	static int[][] board;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<int[]> viruses = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2)
					viruses.add(new int[]{i, j});
			}
		}
		dfs(0);
		System.out.println(answer);
	}

	static void dfs(int depth) {
		if (depth == 3) {
			answer = Math.max(answer, getArea());
			return;
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					dfs(depth+1);
					board[i][j] = 0;
				}
			}
		}
	}
	
	static int getArea() {
		int[][] tmp = new int[n][m];
		for (int i=0; i<n; i++)
			tmp[i] = board[i].clone();
		
		Queue<int[]> q = new LinkedList<>();
		for (int[] virus : viruses)
			q.offer(virus);
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d=0; d<4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (!inRange(nx, ny) || tmp[nx][ny] != 0) continue;
				tmp[nx][ny] = 2;
				q.offer(new int[]{nx, ny});
			}
		}
		
		int cnt = 0;
		for (int i=0; i<n; i++)
			for (int j=0; j<m; j++)
				if (tmp[i][j] == 0) cnt++;
		return cnt;
	}
	
	static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<m;
	}
}
