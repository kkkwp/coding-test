import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long answer = n;
		for (int x : a) {
			x -= b;
			if (x <= 0) continue;
			answer += x / c;
			if (x % c != 0) answer++;
		}
		System.out.println(answer);
	}
}