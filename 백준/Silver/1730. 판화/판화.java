import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String commands = br.readLine();
		boolean[][] vertical = new boolean[n][n];
		boolean[][] horizontal = new boolean[n][n];
		int curR = 0;
		int curC = 0;
		for (char command : commands.toCharArray()) {
			if (command == 'U') {
				if (curR == 0)
					continue;
				vertical[curR][curC] = vertical[curR - 1][curC] = true;
				curR--;
			} else if (command == 'D') {
				if (curR == n - 1)
					continue;
				vertical[curR][curC] = vertical[curR + 1][curC] = true;
				curR++;
			} else if (command == 'L') {
				if (curC == 0)
					continue;
				horizontal[curR][curC] = horizontal[curR][curC - 1] = true;
				curC--;
			} else {
				if (curC == n - 1)
					continue;
				horizontal[curR][curC] = horizontal[curR][curC + 1] = true;
				curC++;
			}
		}

		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (vertical[i][j] && horizontal[i][j]) {
					sb.append("+");
				} else if (vertical[i][j]) {
					sb.append("|");
				} else if (horizontal[i][j]) {
					sb.append("-");
				} else {
					sb.append(".");
				}
			}
			System.out.println(sb);
		}
	}
}
