import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static void hanoi(int a, int b, int n) {
		if (n == 1) {
			sb.append(a).append(' ').append(b).append('\n');
			return;
		}
		hanoi(a, 6 - a - b, n - 1);
		sb.append(a).append(' ').append(b).append('\n');
		hanoi(6 - a - b, b, n - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb.append((1 << n) - 1).append('\n');
		hanoi(1, 3, n);
		System.out.println(sb);
	}
}
