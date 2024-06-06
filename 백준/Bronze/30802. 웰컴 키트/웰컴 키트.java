import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sizes = new int[6];
		for (int i = 0; i < 6; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		int shirts = 0;
		for (int size : sizes) {
			shirts += size / t;
			if (size % t != 0)
				shirts++;
		}
		sb.append(shirts).append('\n');
		sb.append(n / p).append(' ').append(n % p);
		System.out.println(sb);
	}
}
