import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] origin = new int[n];
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			origin[i] = nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, rank++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int num : origin) {
			sb.append(map.get(num)).append(' ');
		}
		System.out.println(sb);
	}
}
