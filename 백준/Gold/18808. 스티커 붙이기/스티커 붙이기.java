import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, r, c;
	static int[][] laptop = new int[42][42];
	static int[][] sticker = new int[12][12];

	static boolean stickable(int x, int y) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sticker[i][j] == 1 && laptop[x + i][y + j] == 1)
					return false;
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sticker[i][j] == 1)
					laptop[x + i][y + j] = 1;
			}
		}
		return true;
	}

	static void rotate() {
		int[][] tmp = new int[12][12];
		for (int i = 0; i < r; i++)
			tmp[i] = sticker[i].clone();

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++)
				sticker[i][j] = tmp[r - 1 - j][i];
		}

		int t = r;
		r = c;
		c = t;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++)
					sticker[i][j] = Integer.parseInt(st.nextToken());
			}

			check:
			for (int rot = 0; rot < 4; rot++) {
				for (int x = 0; x <= n - r; x++) {
					for (int y = 0; y <= m - c; y++) {
						if (stickable(x, y)) {
							break check;
						}
					}
				}
				rotate();
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				answer += laptop[i][j];
			}
		}
		System.out.println(answer);
	}
}
