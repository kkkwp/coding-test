import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> commands = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			commands.add(Integer.parseInt(st.nextToken()));
		}
		Collections.reverse(commands);

		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int command = commands.get(i);
			if (command == 1) {
				deque.addFirst(i + 1);
			} else if (command == 2) {
				int top = deque.removeFirst();
				deque.addFirst(i + 1);
				deque.addFirst(top);
			} else {
				deque.addLast(i + 1);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (deque.size() > 0) {
			sb.append(deque.removeFirst()).append(" ");
		}
		System.out.println(sb);
	}
}
