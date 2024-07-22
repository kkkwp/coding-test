import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		int[] digits = new int[10];
		String result = Long.toString((long)a * b * c);
		for (int i = 0; i < result.length(); i++) {
			digits[result.charAt(i) - '0']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int digit : digits) {
			sb.append(digit).append('\n');
		}
		System.out.println(sb);
	}
}
