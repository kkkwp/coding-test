import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean isPalindrome(int n, int base) {
		int[] digits = new int[20];
		int len = 0;
		while (n > 0) {
			digits[len++] = n % base;
			n /= base;
		}

		for (int i = 0; i < len / 2; i++) {
			if (digits[i] != digits[len - i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			boolean answer = false;
			for (int i = 2; i <= 64; i++) {
				if (isPalindrome(n, i)) {
					answer = true;
					break;
				}
			}
			System.out.println(answer ? 1 : 0);
		}
	}
}
