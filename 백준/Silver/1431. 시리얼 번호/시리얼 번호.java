import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] serials = new String[n];
		for (int i = 0; i < n; i++) {
			serials[i] = br.readLine();
		}

		Arrays.sort(serials, (o1, o2) -> {
			if (o1.length() != o2.length())
				return o1.length() - o2.length();

			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < o1.length(); i++) {
				if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9')
					sum1 += o1.charAt(i) - '0';
				if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9')
					sum2 += o2.charAt(i) - '0';
			}
			if (sum1 != sum2)
				return sum1 - sum2;
			else
				return o1.compareTo(o2);
		});

		for (String serial : serials)
			System.out.println(serial);
	}
}
