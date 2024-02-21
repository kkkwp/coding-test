import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String word = br.readLine();
		doc = doc.replace(word, "1");
		int answer = 0;
		for (char ch : doc.toCharArray()) {
			if (ch == '1') {
				answer += 1;
			}
		}
		System.out.println(answer);
	}
}
