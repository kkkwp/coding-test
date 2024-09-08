import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	static int answer;
	static boolean flag;
	static char[][] board = new char[12][6];

	static void fallDown() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j >= 0; j--) {
				if (board[j][i] != '.') {
					q.offer(board[j][i]);
					board[j][i] = '.';
				}
			}
			int idx = 11;
			while (!q.isEmpty()) {
				board[idx][i] = q.poll();
				idx--;
			}
		}
	}

	static void bfs() {
		Queue<Puyo> q = new LinkedList<>();
		boolean[][] visited = new boolean[12][6];

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] != '.' && !visited[i][j]) {
					q.offer(new Puyo(i, j, board[i][j]));
					visited[i][j] = true;

					List<int[]> list = new ArrayList<>(); // 같은 색의 뿌요 리스트
					list.add(new int[] {i, j});

					while (!q.isEmpty()) {
						Puyo cur = q.poll();
						for (int dir = 0; dir < 4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6)
								continue;
							if (board[nx][ny] == cur.color && !visited[nx][ny]) {
								q.offer(new Puyo(nx, ny, board[nx][ny]));
								visited[nx][ny] = true;
								list.add(new int[] {nx, ny});
							}
						}
					}

					// 리스트에 있는 같은 색의 뿌요가 4개 이상이면 터뜨림
					if (list.size() >= 4) {
						for (int[] l : list) {
							board[l[0]][l[1]] = '.';
							flag = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++)
			board[i] = br.readLine().toCharArray();

		while (true) {
			flag = false;

			bfs();
			fallDown();

			if (!flag)
				break;
			answer++;
		}
		System.out.println(answer);
	}

	static class Puyo {
		int x, y;
		char color;

		Puyo(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
}
