import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] u = new int[n];
		for (int i = 0; i < n; i++) {
			u[i] = Integer.parseInt(br.readLine());
		}

		Set<Integer> sum = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum.add(u[i] + u[j]);
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int target = u[i] - u[j];
				if (sum.contains(target)) {
					answer = Math.max(answer, u[i]);
				}
			}
		}
		System.out.println(answer);
	}
}
