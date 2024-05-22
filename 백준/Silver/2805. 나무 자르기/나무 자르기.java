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

		int left =0, right = 0;
		int[] trees = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, trees[i]);
		}
		
		while (left < right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for (int tree : trees) {
				if (tree - mid > 0) {
					sum += tree - mid;
				}
			}
			if (sum < m) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left - 1);
	}
}
