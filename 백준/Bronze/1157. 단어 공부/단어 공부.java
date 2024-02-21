import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int[] alpha = new int[26];
		for (char ch : str.toCharArray()) {
			alpha[ch - 'A'] += 1;
		}

		int max = -1;
		char answer = '?';
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] == max) {
				answer = '?';
			} else if (alpha[i] > max) {
				max = alpha[i];
				answer = (char)(i + 'A');
			}
		}
		System.out.println(answer);
	}
}
