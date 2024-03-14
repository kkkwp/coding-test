import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] ground = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			ground[i] = Integer.parseInt(st.nextToken());
		}

		int[] commands = new int[n + 2];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			commands[a] += k;
			commands[b + 1] -= k;
		}

		for (int i = 1; i <= n; i++) {
			commands[i] += commands[i - 1];
			ground[i] += commands[i];
		}

		StringBuilder sb = new StringBuilder();
		IntStream.range(1, ground.length)
			.forEach(i -> sb.append(ground[i]).append(" "));
		System.out.println(sb);
	}
}
