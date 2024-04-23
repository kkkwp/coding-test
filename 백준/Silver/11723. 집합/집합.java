import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());

		int s = 0;
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = 0;
			switch (command) {
				case "add":
					x = Integer.parseInt(st.nextToken());
					s |= (1 << x);
					break;
				case "remove":
					x = Integer.parseInt(st.nextToken());
					s &= ~(1 << x);
					break;
				case "check":
					x = Integer.parseInt(st.nextToken());
					int tmp = s & (1 << x);
					sb.append(tmp == 0 ? 0 : 1).append('\n');
					break;
				case "toggle":
					x = Integer.parseInt(st.nextToken());
					s ^= (1 << x);
					break;
				case "all":
					s = (1 << 21) - 1;
					break;
				case "empty":
					s = 0;
					break;
				default:
					break;
			}
		}
		System.out.println(sb);
	}
}
