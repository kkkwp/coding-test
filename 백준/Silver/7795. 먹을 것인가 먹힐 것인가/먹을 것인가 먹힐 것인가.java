import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Integer[] a = new Integer[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());

			Integer[] b = new Integer[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++)
				b[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(a);
			Arrays.sort(b);

			int answer = 0;
			for (Integer i : a) {
				for (Integer j : b) {
					if (i <= j)
						break;
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
