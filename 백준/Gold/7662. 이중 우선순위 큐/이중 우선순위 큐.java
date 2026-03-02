import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 입력 데이터의 수
		StringTokenizer st;
		while (t-->0) {
			TreeMap<Integer, Integer> tree = new TreeMap<>(); // 중복 허용하는 tree
			int k = Integer.parseInt(br.readLine()); // Q에 적용할 연산의 개수
			while (k-->0) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if (op.equals("I"))
					tree.put(n, tree.getOrDefault(n, 0)+1);
				else {
					if (tree.isEmpty()) continue;
					int key = n == 1 ? tree.lastKey() : tree.firstKey();
					if (tree.get(key) == 1)
						tree.remove(key);
					else
						tree.put(key, tree.get(key)-1);
				}
			}

			System.out.println(tree.isEmpty() ? "EMPTY" : tree.lastKey() + " " + tree.firstKey());
		}
	}
}
