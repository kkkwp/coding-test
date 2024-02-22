import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());

		Arrays.sort(nums);

		int start = 0;
		int end = n - 1;
		int answer = 0;
		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum == x) {
				answer++;
				start++;
			} else if (sum < x) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(answer);
	}
}
