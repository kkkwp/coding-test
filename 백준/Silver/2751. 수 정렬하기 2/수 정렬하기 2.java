import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(nums);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int num : nums) {
			bw.write(num + "\n");
		}
		bw.flush();
	}
}
