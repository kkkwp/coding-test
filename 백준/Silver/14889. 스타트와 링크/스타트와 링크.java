import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int answer = Integer.MAX_VALUE;
	static int[][] s;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		visited = new boolean[n];
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++)
				s[i][j] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		System.out.println(answer);
	}

	static void dfs(int depth, int cur) {
		if (depth == n/2) {
			getDiff();
			return;
		}
		
		for (int i=cur; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth+1, i+1);
				visited[i] = false;
			}
		}
	}

	static void getDiff() {
		int start = 0;
		int link = 0;
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if (visited[i] && visited[j])
					start += s[i][j] + s[j][i];
				else if (!visited[i] && !visited[j])
					link += s[i][j] + s[j][i];
			}
		}
		answer = Math.min(answer, Math.abs(start - link));
	}
}
