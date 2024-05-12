import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input1 = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();
		int len1 = input1.length;
		int len2 = input2.length;
		int[][] dp = new int[len2 + 1][len1 + 1];
		for (int i = 1; i <= len2; i++) {
			for (int j = 1; j <= len1; j++) {
				if (input2[i - 1] == input1[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[len2][len1]);
	}
}
