import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());

		for (int i = 1; i <= p; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int[] students = new int[20];
			for (int j = 0; j < 20; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int j = 1; j < 20; j++) {
				for (int k = 0; k < j; k++) {
					if (students[j] < students[k]) {
						cnt++;
					}
				}
			}
			System.out.println(i + " " + cnt);
		}
	}
}
