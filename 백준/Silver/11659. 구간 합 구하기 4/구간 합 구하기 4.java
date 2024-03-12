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

		int[] nums = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] acc = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			acc[i] = acc[i - 1] + nums[i];
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(acc[j] - acc[i - 1]);
		}
	}
}
