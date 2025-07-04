import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] t = new int[n+1]; // 상담 기간
		int[] p = new int[n+1]; // 금액
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n+2];
		for (int i=n; i>=1; i--) {
			int end = i + t[i] - 1; // 상담이 끝나는 날
			if (end <= n)
				dp[i] = Math.max(dp[i+1], dp[i+t[i]] + p[i]); // 상담을 하는 경우와 하지 않는 경우 중 최대값
			else
				dp[i] = dp[i+1]; // 상담을 할 수 없는 경우는 이전 값 그대로
		}
		System.out.println(dp[1]);
	}
}