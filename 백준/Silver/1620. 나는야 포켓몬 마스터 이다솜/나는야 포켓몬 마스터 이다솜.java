import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> book1 = new HashMap<>();
		HashMap<String, Integer> book2 = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String pocketmon = br.readLine();
			book1.put(i, pocketmon);
			book2.put(pocketmon, i);
		}

		for (int i = 0; i < m; i++) {
			String quiz = br.readLine();
			if ('A' <= quiz.charAt(0)) {
				System.out.println(book2.get(quiz));
			} else {
				System.out.println(book1.get(Integer.parseInt(quiz)));
			}
		}
	}
}
