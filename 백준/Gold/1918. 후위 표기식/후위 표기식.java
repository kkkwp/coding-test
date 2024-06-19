import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int priority(char op) {
		if (op == '*' || op == '/') {
			return 2;
		} else if (op == '+' || op == '-') {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		String exp = br.readLine();
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			switch (ch) {
				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
						sb.append(stack.pop());
					}
					stack.push(ch);
					break;
				case '(':
					stack.push(ch);
					break;
				case ')':
					while (!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();
					break;
				default:
					sb.append(ch);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
