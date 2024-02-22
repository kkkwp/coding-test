import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] rows = new int[n];
		int[] cols = new int[m];
		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (tmp[j] == 'X') {
					rows[i]++;
					cols[j]++;
				}
			}
		}
		int row = 0;
		for (int r : rows) {
			if (r == 0) {
				row++;
			}
		}
		int col = 0;
		for (int c : cols) {
			if (c == 0) {
				col++;
			}
		}
		System.out.println(Math.max(row, col));
	}
}
