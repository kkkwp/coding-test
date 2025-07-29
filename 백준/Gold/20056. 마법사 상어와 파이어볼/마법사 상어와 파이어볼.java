import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static List<Fireball>[][] board;
	static List<Fireball> fireballs = new ArrayList<>();
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1; // 위치
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken()); // 질량
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 방향
			fireballs.add(new Fireball(r, c, m, s, d));
		}

		// board 초기화
		board = new ArrayList[N][N];
		for (int i=0; i<N; i++)
			for (int j=0; j<N; j++)
				board[i][j] = new ArrayList<>();

		while (K-->0) {
			move();
			split();
		}

		int answer = 0;
		for (Fireball f : fireballs)
			answer += f.m;
		System.out.println(answer);
	}

	static void move() {
		// 자신의 방향 d로 속력 s칸 만큼 이동
		for (Fireball f : fireballs) {
			int nr = (f.r + dx[f.d]*(f.s%N) + N) % N;
			int nc = (f.c + dy[f.d]*(f.s%N) + N) % N;
			board[nr][nc].add(new Fireball(nr, nc, f.m, f.s, f.d));
		}
		fireballs.clear();
	}

	static void split() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (board[i][j].isEmpty()) continue;
				if (board[i][j].size() == 1)
					fireballs.add(board[i][j].get(0));
				else {
					// 2개 이상의 파이어볼이 있는 칸
					// 1. 같은 칸에 있는 파이어볼은 하나로 합쳐짐
					int sumM = 0, sumS = 0;
					boolean allEven = true, allOdd = true;
					for (Fireball f : board[i][j]) {
						sumM += f.m;
						sumS += f.s;

						// 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 됨
						if (f.d % 2 == 0) allOdd = false;
						else allEven = false;
					}
					// 2. 파이어볼은 4개로 나누어짐
					// 2-1) 질량 변화(질량이 0인 파이어볼은 소멸됨)
					int nm = sumM / 5;
					if (nm == 0) {
						board[i][j].clear();
						continue;
					}

					// 2-2) 속력 변화
					int ns = sumS / board[i][j].size();

					// 2-3) 방향 변화
					int[] nd = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
					for (int d : nd)
						fireballs.add(new Fireball(i, j, nm, ns, d));
				}
				board[i][j].clear();
			}
		}
	}
}

class Fireball {
	int r, c, m, s, d;

	public Fireball(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}
