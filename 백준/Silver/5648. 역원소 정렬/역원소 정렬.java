import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		long[] nums = new long[n];
		while (n > 0) {
			while (st.hasMoreTokens()) {
				String num = new StringBuilder(st.nextToken()).reverse().toString();
				nums[--n] = Long.parseLong(num);
			}
			if (n > 0) {
				st = new StringTokenizer(br.readLine());
			}
		}
		
		Arrays.sort(nums);
        
		for (long num : nums)
			System.out.println(num);
	}
}
