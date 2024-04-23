import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max = -1;
		int idx = -1;
		for (int i = 0; i < 9; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input > max) {
				max = input;
				idx = i + 1;
			}
		}
		sb.append(max).append('\n').append(idx);
		System.out.println(sb);
	}
}
