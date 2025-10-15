import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new int[m]; // 결과물은 m개의 수
		visited = new boolean[n+1]; // 1부터 n까지의 수를 방문 체크
		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int idx) {
		if (idx == m) {
			for (int r : result)
				sb.append(r).append(" ");
			sb.append("\n");
			return;
		}

		for (int i=1; i<=n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[idx] = i;
				dfs(idx+1);
				visited[i] = false;
			}
		}
	}
}
