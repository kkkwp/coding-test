import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new int[m]; // 결과물은 m개의 수
		dfs(0, 1);
		System.out.println(sb);
	}

	static void dfs(int idx, int at) {
		if (idx == m) {
			for (int r : result)
				sb.append(r).append(" ");
			sb.append("\n");
			return;
		}

		for (int i=at; i<=n; i++) {
			result[idx] = i;
			dfs(idx+1, i+1);
		}
	}
}
