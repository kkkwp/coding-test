import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int num = i;
			int digit = 0;
			while (num > 0) {
				digit += num % 10;
				num /= 10;
			}
			if (digit + i == n) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
