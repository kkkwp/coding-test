import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] triangle = new int[3];
			for (int i = 0; i < 3; i++) {
				triangle[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(triangle);
			if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0)
				break;
			if (Math.pow(triangle[0], 2) + Math.pow(triangle[1], 2) == Math.pow(triangle[2], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
