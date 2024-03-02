import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int digit = n % b;
			if (digit < 10) {
				sb.append(digit);
			} else {
				sb.append((char)('A' + digit - 10));
			}
			n /= b;
		}
		System.out.println(sb.reverse());
	}
}
