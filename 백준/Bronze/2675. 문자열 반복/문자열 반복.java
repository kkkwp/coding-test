import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			for (int i = 0; i < s.length(); i++) {
				sb.append(String.valueOf(s.charAt(i)).repeat(r));
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
