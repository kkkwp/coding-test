import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new LinkedList<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case "push":
					q.offer(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					sb.append(q.isEmpty() ? -1 : q.pop()).append('\n');
					break;
				case "size":
					sb.append(q.size()).append('\n');
					break;
				case "empty":
					sb.append(q.isEmpty() ? 1 : 0).append('\n');
					break;
				case "front":
					sb.append(q.isEmpty() ? -1 : q.getFirst()).append('\n');
					break;
				case "back":
					sb.append(q.isEmpty() ? -1 : q.getLast()).append('\n');
					break;
				default:
					break;
			}
		}
		System.out.println(sb);
	}
}
