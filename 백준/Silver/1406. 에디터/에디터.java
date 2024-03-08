import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String init = br.readLine();
		int m = Integer.parseInt(br.readLine());
		List<Character> list = new LinkedList<>();
		for (char ch : init.toCharArray()) {
			list.add(ch);
		}
		
		ListIterator<Character> iter = list.listIterator(init.length());
		while (m-- > 0) {
			String tmp = br.readLine();
			char cmd = tmp.charAt(0);
			if (cmd == 'L') {
				if (iter.hasPrevious()) {
					iter.previous();
				}
			} else if (cmd == 'D') {
				if (iter.hasNext()) {
					iter.next();
				}
			} else if (cmd == 'B') {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} else {
				iter.add(tmp.charAt(2));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : list) {
			sb.append(ch);
		}
		System.out.println(sb);
	}
}
