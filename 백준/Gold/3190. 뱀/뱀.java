import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] board;
	static int[] dr = {0, 1, 0, -1}; // 동, 남, 서, 북
	static int[] dc = {1, 0, -1, 0};
	static Map<Integer, Character> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 보드의 크기
		int k = Integer.parseInt(br.readLine()); // 사과의 크기
		board = new int[n][n];
		StringTokenizer st;
		while (k-->0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			board[r][c] = 1; // 사과
		}
		int l = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
		while (l-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			map.put(x, ch);
		}
		System.out.println(game());
	}

	static int game() {
		int time = 0;
		int r = 0, c = 0, dir = 0; // 시작 방향은 동쪽
		Deque<int[]> snake = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		snake.addFirst(new int[]{r, c});
		visited[r][c] = true;

		while (true) {
			time++;
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 벽이나 자기자신의 몸과 부딪히면 게임 끝
			if (!inRange(nr, nc) || visited[nr][nc]) break;

			snake.addFirst(new int[]{nr, nc});
			visited[nr][nc] = true;

			// 사과가 있는 경우 → 사과가 없어지고 꼬리는 움직이지 않음
			if (board[nr][nc] == 1) board[nr][nc] = 0;
			// 사과가 없는 경우 → 꼬리가 위치한 칸을 비워줌
			else {
				int[] tail = snake.pollLast();
				visited[tail[0]][tail[1]] = false;
			}

			r = nr;
			c = nc;

			// 방향 전환
			if (map.containsKey(time)) {
				char ch = map.get(time);
				if (ch == 'L')
					dir = (dir + 3) % 4; // 왼쪽으로 회전
				else
					dir = (dir + 1) % 4; // 오른쪽으로 회전
			}
		}
		return time;
	}

	static boolean inRange(int r, int c) {
		return 0<=r && r<n && 0<=c && c<n;
	}
}
