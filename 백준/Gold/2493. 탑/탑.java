import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int height = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= height) {
					sb.append(stack.peek()[0]).append(' ');
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append('0').append(' ');
			}
			stack.push(new int[] {i, height});
		}
		System.out.println(sb);
	}
}
