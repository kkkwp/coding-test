import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] input = new int[2][6];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			input[gender][grade - 1]++;
		}

		int answer = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				answer += (int)Math.ceil((double)input[i][j] / k);
			}
		}
		System.out.println(answer);
	}
}
