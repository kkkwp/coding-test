import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] data = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			else
				return o1[1] - o2[1];
		});

		StringBuilder sb = new StringBuilder();
		for (int[] x : data) {
			sb.append(x[0]).append(" ").append(x[1]).append("\n");
		}
		System.out.println(sb);
	}
}
