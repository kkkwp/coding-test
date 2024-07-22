import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String strfry(String before, String after) {
		int[] alphabets = new int[26];
		for (int i = 0; i < before.length(); i++)
			alphabets[before.charAt(i) - 'a']++;
		for (int i = 0; i < after.length(); i++)
			alphabets[after.charAt(i) - 'a']--;
		for (int alphabet : alphabets) {
			if (alphabet != 0) {
				return "Impossible";
			}
		}
		return "Possible";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String before = st.nextToken();
			String after = st.nextToken();
			System.out.println(strfry(before, after));
		}
	}
}
