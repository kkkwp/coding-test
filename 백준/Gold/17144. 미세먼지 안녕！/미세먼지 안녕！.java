import java.io.*;
import java.util.*;

public class Main {
	static int r, c, t;
	static int machine = -1;
	static int[][] board, tmp;
	static int[] dx = {-1, 0, 1, 0}; // 시계 방향
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		for (int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<c; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1 && machine == -1)
					machine = i; // 공기청정기 윗 부분
			}
		}

		while (t-->0) {
			spread();
			purify();
		}

		int answer = 0;
		for (int i=0; i<r; i++)
			for (int j=0; j<c; j++)
				if (board[i][j] > 0)
					answer += board[i][j];
		System.out.println(answer);
	}

	static void spread() {
		tmp = new int[r][c];
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (board[i][j] > 0) {
					int amount = board[i][j] / 5;
					int cnt = 0;
					for (int d=0; d<4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (!inRange(nx, ny)) continue;
						if (board[nx][ny] == -1) continue;
						tmp[nx][ny] += amount;
						cnt++;
					}
					board[i][j] -= amount * cnt;
				}
			}
		}
		
		for (int i=0; i<r; i++)
			for (int j=0; j<c; j++)
				board[i][j] += tmp[i][j];
	}

	static void purify() {
		// 위쪽 → 반시계 방향
		int x = machine;
		for (int i=x-1; i>0; i--) board[i][0] = board[i-1][0];
		for (int i=0; i<c-1; i++) board[0][i] = board[0][i+1];
		for (int i=0; i<x; i++) board[i][c-1] = board[i+1][c-1];
		for (int i=c-1; i>0; i--) board[x][i] = board[x][i-1];
		board[x][1] = 0;
		board[x][0] = -1;

		// 아래쪽 → 시계 방향
		x = machine + 1;
		for (int i=x; i<r-1; i++) board[i][0] = board[i+1][0];
		for (int i=0; i<c-1; i++) board[r-1][i] = board[r-1][i+1];
		for (int i=r-1; i>x; i--) board[i][c-1] = board[i-1][c-1];
		for (int i=c-1; i>0; i--) board[x][i] = board[x][i-1];
		board[x][1] = 0;
		board[x][0] = -1;
	}

	static boolean inRange(int x, int y) {
		return 0<=x && x<r && 0<=y && y<c;
	}
}
