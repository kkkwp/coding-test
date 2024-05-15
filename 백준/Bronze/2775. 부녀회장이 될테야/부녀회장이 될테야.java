import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[][] apt = new int[15][15];
		for (int i = 1; i <= 14; i++) {
			apt[0][i] = i;
		}
		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(apt[k][n]).append("\n");
		}
		System.out.println(sb);
	}
}
