import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			String l = br.readLine();
			List<Character> answer = new LinkedList<>();
			ListIterator<Character> iter = answer.listIterator();
			for (char c : l.toCharArray()) {
				switch (c) {
					case '<':
						if (iter.hasPrevious())
							iter.previous();
						break;
					case '>':
						if (iter.hasNext())
							iter.next();
						break;
					case '-':
						if (iter.hasPrevious()) {
							iter.previous();
							iter.remove();
						}
						break;
					default:
						iter.add(c);
						break;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (char c : answer)
				sb.append(c);
			System.out.println(sb);
		}
	}
}
