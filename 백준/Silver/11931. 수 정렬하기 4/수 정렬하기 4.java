import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Integer[] nums = new Integer[n];
		for (int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(br.readLine());
		Arrays.sort(nums, Collections.reverseOrder());
		for (Integer num : nums)
			bw.write(num + "\n");
		bw.flush();
	}
}
