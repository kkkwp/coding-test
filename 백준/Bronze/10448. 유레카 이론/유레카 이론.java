import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int LIMIT = 45;

	private static boolean possible(int[] triangle, int n) {
		for (int i = 1; i < LIMIT; i++) {
			for (int j = i; j < LIMIT; j++) {
				for (int k = j; k < LIMIT; k++) {
					if (triangle[i] + triangle[j] + triangle[k] == n) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		int[] triangle = new int[LIMIT];
		for (int i = 0; i < LIMIT; i++) {
			triangle[i] = i * (i + 1) / 2;
		}

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(possible(triangle, k) ? "1" : "0");
		}
	}
}
