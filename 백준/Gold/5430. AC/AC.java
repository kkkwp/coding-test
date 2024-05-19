import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static String ac(char[] p, Deque<Integer> deque) {
		boolean isRight = true;
		for (char cmd : p) {
			if (cmd == 'R') {
				isRight = !isRight;
			} else {
				if (deque.isEmpty())
					return "error";
				if (isRight) {
					deque.removeFirst();
				} else {
					deque.removeLast();
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		while (!deque.isEmpty()) {
			sb.append(isRight ? deque.removeFirst() : deque.removeLast());
			if (!deque.isEmpty()) {
				sb.append(',');
			}
		}
		sb.append(']');
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			for (int i = 0; i < n; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			System.out.println(ac(p, deque));
		}
	}
}
