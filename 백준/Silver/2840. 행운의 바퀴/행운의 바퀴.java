import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[] wheel = new char[n];
		Arrays.fill(wheel, '?');

		boolean[] alpha = new boolean[26];
		int cur = 0;
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			cur = (cur + n - (s % n)) % n;
			if (wheel[cur] == ch)
				continue;
			if (wheel[cur] == '?' && !alpha[ch - 'A']) {
				wheel[cur] = ch;
				alpha[ch - 'A'] = true;
			} else {
				System.out.println('!');
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(wheel[(cur + i) % n]);
		}
		System.out.println(sb);
	}
}
