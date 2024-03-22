import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int m = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		long r = 1;
		long sum = 0;
		for (int i = 0; i < l; i++) {
			sum += (str[i] - 'a' + 1) * r % m;
			r = r * 31 % m;
		}
		System.out.println(sum % m);
	}
}
