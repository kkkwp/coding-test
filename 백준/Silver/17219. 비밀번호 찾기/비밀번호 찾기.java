import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
		int m = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수

		HashMap<String, String> map = new HashMap<>();
		while (n-->0) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			map.put(site, password);
		}

		while (m-->0) {
			String input = br.readLine();
			System.out.println(map.get(input));
		}
	}
}
