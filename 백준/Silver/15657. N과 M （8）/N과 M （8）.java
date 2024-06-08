import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] nums, arr;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int at, int depth) {
		if (depth == m) {
			for (int x : arr) {
				sb.append(x).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = at; i < n; i++) {
			arr[depth] = nums[i];
			dfs(i, depth + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		dfs(0, 0);
		System.out.println(sb);
	}
}
