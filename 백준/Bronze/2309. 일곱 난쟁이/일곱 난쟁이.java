import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarfs = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			sum += dwarfs[i];
		}
		Arrays.sort(dwarfs);
		int a = 0;
		int b = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - dwarfs[i] - dwarfs[j] == 100) {
					a = i;
					b = j;
					break;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i != a && i != b) {
				System.out.println(dwarfs[i]);
			}
		}
	}
}
