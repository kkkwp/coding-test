import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alphabets = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabets[s.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int alphabet : alphabets) {
			sb.append(alphabet).append(' ');
		}
		System.out.println(sb);
	}
}
