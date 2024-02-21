import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder answer = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if (ch >= 'A' && ch <= 'Z') {
				answer.append(Character.toLowerCase(ch));
			} else {
				answer.append(Character.toUpperCase(ch));
			}
		}
		System.out.println(answer);
	}
}
