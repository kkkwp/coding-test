import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l, c;
	static char[] alpha, code;
	static StringBuilder sb = new StringBuilder();

	static boolean isValid() {
		int vowel = 0;
		int consonant = 0;
		for (char ch : code) {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				vowel++;
			else
				consonant++;
		}
		return vowel >= 1 && consonant >= 2;
	}

	static void dfs(int at, int depth) {
		if (depth == l) {
			if (isValid()) {
				System.out.println(code);
			}
			return;
		}
		for (int i = at; i < c; i++) {
			code[depth] = alpha[i];
			dfs(i + 1, depth + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		alpha = new char[c];
		code = new char[l];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		dfs(0, 0);
	}
}
