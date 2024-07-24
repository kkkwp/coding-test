import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int cur = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			for (; cur <= num; cur++) {
				stack.push(cur);
				sb.append('+').append('\n');
			}
			if (stack.peek() == num) {
				stack.pop();
				sb.append('-').append('\n');
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}
}
