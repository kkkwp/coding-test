import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();

		int[] digits = new int[9];
		for (int i = 0; i < n.length(); i++) {
			int digit = n.charAt(i) - '0';
			if (digit == 9)
				digits[6]++;
			else
				digits[digit]++;
		}

		int max = 0;
		digits[6] = (digits[6] + 1) / 2;
		for (int digit : digits) {
			max = Math.max(max, digit);
		}
		System.out.println(max);
	}
}
