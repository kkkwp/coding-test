import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int cnt;
	static boolean[] col, right, left;

	static void dfs(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (col[i] || right[depth + i] || left[depth - i + n - 1])
				continue;
			col[i] = true;
			right[depth + i] = true;
			left[depth - i + n - 1] = true;
			dfs(depth + 1);
			col[i] = false;
			right[depth + i] = false;
			left[depth - i + n - 1] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		col = new boolean[n];
		right = new boolean[2 * n];
		left = new boolean[2 * n];
		dfs(0);
		System.out.println(cnt);
	}
}
