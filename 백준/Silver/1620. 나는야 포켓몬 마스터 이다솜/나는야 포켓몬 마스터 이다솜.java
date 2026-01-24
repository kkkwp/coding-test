import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도감에 수록되어 있는 포켓몬의 개수
		int m = Integer.parseInt(st.nextToken()); // 맞춰야 하는 문재의 개수

		HashMap<Integer, String> numberMap = new HashMap<>();
		HashMap<String, Integer> nameMap = new HashMap<>();
		for (int i=1; i<=n; i++) {
			String name = br.readLine();
			numberMap.put(i, name);
			nameMap.put(name, i);
		}

		while (m-->0) {
			String quiz = br.readLine();
			System.out.println('A' <= quiz.charAt(0)
				? nameMap.get(quiz)
				: numberMap.get(Integer.parseInt(quiz)));
		}
	}
}
