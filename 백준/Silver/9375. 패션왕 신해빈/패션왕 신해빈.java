import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t  = Integer.parseInt(br.readLine()); // 테스트 케이스
		while (t-->0) {
			HashMap<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine()); // 혜빈이가 가진 의상의 수
			while (n-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 0) + 1);
			}

			int answer = 1;
			for (int value : map.values())
				answer *= (value + 1);
			System.out.println(answer-1);
		}
	}
}
