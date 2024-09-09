import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] operation;
	static int[][] gear = new int[4][8];

	static void check(int idx) {
		for (int i = idx - 1; i >= 0; i--) { // 왼쪽에 있는 톱니바퀴 체크
			if (gear[i][2] == gear[i + 1][6])
				break;
			operation[i] = -operation[i + 1];
		}
		for (int i = idx + 1; i < 4; i++) { // 오른쪽에 있는 톱니바퀴 체크
			if (gear[i][6] == gear[i - 1][2])
				break;
			operation[i] = -operation[i - 1];
		}
	}

	static void operate() {
		int tmp = 0;
		for (int i = 0; i < 4; i++) {
			if (operation[i] == 1) { // 시계방향
				tmp = gear[i][7];
				for (int j = 7; j > 0; j--)
					gear[i][j] = gear[i][j - 1];
				gear[i][0] = tmp;
			}
			if (operation[i] == -1) { // 반시계방향
				tmp = gear[i][0];
				for (int j = 0; j < 7; j++)
					gear[i][j] = gear[i][j + 1];
				gear[i][7] = tmp;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++)
				gear[i][j] = line.charAt(j) - '0';
		}

		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			operation = new int[4];
			operation[idx] = dir;
			check(idx);
			operate();
		}

		int answer = 0;
		if (gear[0][0] == 1)
			answer += 1;
		if (gear[1][0] == 1)
			answer += 2;
		if (gear[2][0] == 1)
			answer += 4;
		if (gear[3][0] == 1)
			answer += 8;
		System.out.println(answer);
	}
}
