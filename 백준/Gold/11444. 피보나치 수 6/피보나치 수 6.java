import java.io.*;
import java.util.*;

public class Main {
	static final long MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		System.out.println(fib(n)[0]);
	}

	static long[] fib(long n) {
		// base
		if (n == 0) return new long[]{0, 1};

		// 절반 길이로 나누어 계산
		long[] ab = fib(n >> 1); // k = n/2
		long a = ab[0]; // fib(k)
		long b = ab[1]; // fib(k+1)

		// 2k번째와 2k+1번째 피보나치 수 계산 공식
		// fib(2k) = fib(k) * [2 * fib(k+1) – F(k)]
		// fib(2k+1) = fib(k)² + fib(k+1)²
		long c = (a * (2*b%MOD - a + MOD) % MOD) % MOD;
		long d = (a*a%MOD + b*b%MOD) % MOD;

		// n이 짝수인지 홀수인지에 따라 결과 선택
		if ((n & 1) == 0) return new long[]{c, d};
		else return new long[]{d, (c+d) % MOD};
	}
}
