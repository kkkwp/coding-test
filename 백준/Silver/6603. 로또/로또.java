import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] nums, arr;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int at, int depth) {
		if (depth == 6) {
			for (int x : arr) {
				sb.append(x).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = at; i < k; i++) {
			arr[depth] = nums[i];
			dfs(i + 1, depth + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;

			nums = new int[k];
			arr = new int[6];
			for (int i = 0; i < k; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
