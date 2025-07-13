import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		board = new int[n][n];
		List<Integer> order = new ArrayList<>();
		for (int i=0; i<n*n; i++) {
			st = new StringTokenizer(br.readLine());
			int student =  Integer.parseInt(st.nextToken());
			order.add(student);
			List<Integer> likes = new ArrayList<>();
			for (int j=0; j<4; j++)
				likes.add(Integer.parseInt(st.nextToken()));
			map.put(student, likes);
		}

		for (int student : order)
			placeStudent(student);
		System.out.println(calcSatisfaction());
	}

	static void placeStudent(int student) {
		int maxLikes = -1, maxEmpty = -1;
		int r = 0, c = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (board[i][j] != 0) continue;

				int likes = 0, empty = 0;
				for (int d=0; d<4; d++) {
					int ni = i + dr[d];
					int nj = j + dc[d];
					if (!inRange(ni, nj)) continue;
					if (board[ni][nj] == 0) empty++;
					else if (map.get(student).contains(board[ni][nj])) likes++;
				}

				// 1. 좋아하는 학생이 가장 많은 칸
				// 2. 1이 여러 개 → 비어 있는 칸이 가장 많은 칸
				// 3. 2가 여러 개 → 행의 번호가 가장 작은 칸, 열의 번호가 가장 작은 칸
				if (
					(likes > maxLikes)
					|| (likes == maxLikes && empty > maxEmpty)
					|| (likes == maxLikes && empty == maxEmpty && (i < r || (i == r && j < c)))
				) {
					maxLikes = likes;
					maxEmpty = empty;
					r = i;
					c = j;
				}
			}
		}
		board[r][c] = student;
	}

	static int calcSatisfaction() {
		int sum = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				int student = board[i][j];
				int cnt = 0;
				for (int d=0; d<4; d++) {
					int ni = i + dr[d];
					int nj = j + dc[d];
					if (!inRange(ni, nj)) continue;
					if (map.get(student).contains(board[ni][nj])) cnt++;
				}
				if (cnt > 0)
					sum += (int)Math.pow(10, cnt-1);
			}
		}
		return sum;
	}

	static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
}
