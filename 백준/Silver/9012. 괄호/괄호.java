import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == '(') {
					stack.push(ch);
				} else if (stack.empty()) {
					stack.push(ch);
					break;
				} else {
					stack.pop();
				}
			}
			
			if (stack.empty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
