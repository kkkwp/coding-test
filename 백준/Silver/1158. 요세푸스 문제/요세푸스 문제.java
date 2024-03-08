import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int[] answer = new int[n];
		int cur = 0;
		for (int i = 0; i < n; i++) {
			int target = (cur + k - 1) % list.size();
			answer[i] = list.remove(target);
			cur = target;
		}
		System.out.println("<" + Arrays.stream(answer)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(", ")) + ">");
	}
}
