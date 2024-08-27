import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, s, answer;
	static int[] nums;

	static void dfs(int depth, int sum) {
		if (depth == n) {
			if (sum == s)
				answer++;
			return;
		}
		dfs(depth + 1, sum + nums[depth]); // 지금 수를 선택함
		dfs(depth + 1, sum); // 지금 수를 선택하지 않음
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		System.out.println(s == 0 ? answer - 1 : answer);
	}
}
