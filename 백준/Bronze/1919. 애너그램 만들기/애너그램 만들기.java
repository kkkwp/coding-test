import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26];
		String input = br.readLine();
		for (char ch : input.toCharArray()) {
			alpha[ch - 'a'] += 1;
		}
		String output = br.readLine();
		for (char ch : output.toCharArray()) {
			alpha[ch - 'a'] -= 1;
		}
		System.out.println(Arrays.stream(alpha)
			.map(Math::abs)
			.sum());
	}
}
