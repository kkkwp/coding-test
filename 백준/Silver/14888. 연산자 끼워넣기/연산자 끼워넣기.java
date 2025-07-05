import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] a;
	static int[] ops = new int[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[n];
		for (int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++)
			ops[i] = Integer.parseInt(st.nextToken());

		dfs(1, a[0]);
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int depth, int result) {
		if (depth == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i=0; i<4; i++) {
			if (ops[i] == 0) continue;
			ops[i]--;
			if (i == 0)
				dfs(depth+1, result + a[depth]);
			else if (i == 1)
				dfs(depth+1, result - a[depth]);
			else if (i == 2)
				dfs(depth+1, result * a[depth]);
			else {
				if (result < 0)
					dfs(depth+1, -(-result / a[depth]));
				else
					dfs(depth+1, result / a[depth]);
			}
			ops[i]++;
		}
	}
}